package it.unical.ingsw.onthebeach.persistenza.dao.jdbc;

import it.unical.ingsw.onthebeach.model.Lido;
import it.unical.ingsw.onthebeach.persistenza.dao.LidoDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LidoDaoJDBC implements LidoDao{

	Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
			"postgres", "root");
	public LidoDaoJDBC(Connection conn) throws SQLException {
		this.conn = conn;
	}
	
	@Override
	public List<Lido> findAll() {
		List<Lido> lidi = new ArrayList<Lido>();
		String query = "SELECT * FROM lido;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			rs = st.executeQuery();
			while(rs.next()) {
				Lido lido = new Lido();
				lido.setNome(rs.getString("nome"));
				lido.setPosizione(rs.getString("posizione"));
				lido.setNumero(rs.getString("numero"));
				lido.setEmail(rs.getString("email"));
				lido.setDescrizione(rs.getString("descrizione"));
				lido.setFoto(rs.getBytes("foto"));
				lido.setNumeroOmbrelloni(rs.getInt("numero_ombrelloni"));
				lido.setUsernameGestore(rs.getString("username_gestore"));
				lidi.add(lido);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return lidi;
	}

	@Override
	public Lido findByPrimaryKey(String nome) {
		Lido lido = null;
		String query = "SELECT * FROM lido WHERE nome=?;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, nome);
			rs = st.executeQuery();
			if(rs.next()) {
				lido = new Lido();
				lido.setNome(rs.getString("nome"));
				lido.setPosizione(rs.getString("posizione"));
				lido.setNumero(rs.getString("numero"));
				lido.setEmail(rs.getString("email"));
				lido.setDescrizione(rs.getString("descrizione"));
				lido.setFoto(rs.getBytes("foto"));
				lido.setNumeroOmbrelloni(rs.getInt("numero_ombrelloni"));
				lido.setUsernameGestore(rs.getString("username_gestore"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return lido;
	}

	@Override
	public List<Lido> findBest3() {
		List<Lido> lidi = new ArrayList<Lido>();
		String query = "select l.nome, l.posizione, l.numero, l.email, l.descrizione, l.foto, l.numero_ombrelloni, l.username_gestore, AVG(r.star) as media, count(r.star) as nrece" +
				" from lido l ,prenotazione p, recensione r" +
				" where l.nome=p.nome_lido and p.id_prenotazione = r.id_prenotazione" +
				" group by l.nome" +
				" order by media, nrece desc" +
				" limit 3";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			rs = st.executeQuery();
			while(rs.next()) {
				Lido lido = new Lido();
				lido.setNome(rs.getString("nome"));
				lido.setPosizione(rs.getString("posizione"));
				lido.setNumero(rs.getString("numero"));
				lido.setEmail(rs.getString("email"));
				lido.setDescrizione(rs.getString("descrizione"));
				lido.setFoto(rs.getBytes("foto"));
				lido.setNumeroOmbrelloni(rs.getInt("numero_ombrelloni"));
				lido.setUsernameGestore(rs.getString("username_gestore"));
				lidi.add(lido);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return lidi;
	}

	@Override
	public boolean saveOrUpdate(Lido lido) {
		String saveQuery = "INSERT INTO lido(nome, posizione, numero, email, descrizione, foto, numero_ombrelloni, username_gestore) "
				+ "VALUES(?,?,?,?,?,?,?,?);";
		String updateQuery = "UPDATE lido SET posizione=?, numero=?, email=?, descrizione=?, foto=?, numero_ombrelloni=?, "
				+ "username_gestore=? WHERE nome=?;";
		PreparedStatement st = null;
		if(!existLido(lido)) {
			//SAVE
			try {
				st = conn.prepareStatement(saveQuery);
				st.setString(1, lido.getNome());
				st.setString(2, lido.getPosizione());
				st.setString(3, lido.getNumero());
				st.setString(4, lido.getEmail());
				st.setString(5, lido.getDescrizione());
				st.setBytes(6, lido.getFoto());
				st.setInt(7, lido.getNumeroOmbrelloni());
				st.setString(8, lido.getUsernameGestore());
				st.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				closeStatement(st);
			}
		}
		else {
			//UPDATE
			try {
				st = conn.prepareStatement(updateQuery);
				st.setString(1, lido.getPosizione());
				st.setString(2, lido.getNumero());
				st.setString(3, lido.getEmail());
				st.setString(4, lido.getDescrizione());
				st.setBytes(5, lido.getFoto());
				st.setInt(6, lido.getNumeroOmbrelloni());
				st.setString(7, lido.getUsernameGestore());
				st.setString(8, lido.getNome());
				st.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				closeStatement(st);
			}
		}
		return true;
	}




	@Override
	public boolean delete(Lido lido) {
		String nome = lido.getNome();
		String query = "DELETE FROM lido WHERE nome=?;";
		PreparedStatement st = null;
		if(existLido(lido)) {
			try {
				st = conn.prepareStatement(query);
				st.setString(1, nome);
				st.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				closeStatement(st);
			}
			return true;
		}
		return false;
	}
	
	
	private boolean existLido(Lido lido) {
		String nome = lido.getNome();
		String query = "SELECT * FROM lido WHERE nome=?;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, nome);
			rs = st.executeQuery();
			if(rs.next())
				return true;
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
	}
	
	private void closeStatement(PreparedStatement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeResult(ResultSet result) {
		try {
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Lido findByGestore(String username) {
		Lido lido = null;
		String query = "SELECT * FROM lido WHERE username_gestore=?;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, username);
			rs = st.executeQuery();
			if(rs.next()) {
				lido = new Lido();
				lido.setNome(rs.getString("nome"));
				lido.setPosizione(rs.getString("posizione"));
				lido.setNumero(rs.getString("numero"));
				lido.setEmail(rs.getString("email"));
				lido.setDescrizione(rs.getString("descrizione"));
				lido.setFoto(rs.getBytes("foto"));
				lido.setNumeroOmbrelloni(rs.getInt("numero_ombrelloni"));
				lido.setUsernameGestore(rs.getString("username_gestore"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return lido;
	}


	public byte[] trovaImmagine(String id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String query = "SELECT foto FROM lido WHERE nome = ?";

		try {
			st = conn.prepareStatement(query);
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				byte[] imgBytes = rs.getBytes("foto");
				return imgBytes;
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}

		return null;
	}

}