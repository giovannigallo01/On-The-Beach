package it.unical.ingsw.onthebeach.persistenza.dao.jdbc;

import it.unical.ingsw.onthebeach.model.Prenotazione;
import it.unical.ingsw.onthebeach.persistenza.dao.PrenotazioneDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneDaoJDBC implements PrenotazioneDao {

	Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
			"postgres", "root");
	
	public PrenotazioneDaoJDBC(Connection conn) throws SQLException {
		this.conn = conn;
	}
	
	@Override
	public List<Prenotazione> findAll() {
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		String query = "SELECT * FROM prenotazione;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			rs = st.executeQuery();
			while(rs.next()) {
				Prenotazione prenotazione = new Prenotazione();
				prenotazione.setIdPrenotazione(rs.getLong("id_prenotazione"));
				prenotazione.setPrezzoTotale(rs.getFloat("prezzo_totale"));
				prenotazione.setDescrizione(rs.getString("descrizione"));
				prenotazione.setDataPrenotazione(String.valueOf(rs.getDate("data_prenotazione")));
				prenotazione.setDataInizio(String.valueOf(rs.getDate("data_inizio")));
				prenotazione.setDataFine(String.valueOf(rs.getDate("data_fine")));
				prenotazione.setUsernameCliente(rs.getString("username_cliente"));
				prenotazione.setNomeLido(rs.getString("nome_lido"));
				prenotazioni.add(prenotazione);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return prenotazioni;
	}

	@Override
	public Prenotazione findByPrimaryKey(long id) {
		Prenotazione prenotazione = null;
		String query = "SELECT * FROM prenotazione WHERE id_prenotazione=?;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			st.setLong(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				prenotazione = new Prenotazione();
				prenotazione.setIdPrenotazione(rs.getLong("id_prenotazione"));
				prenotazione.setPrezzoTotale(rs.getFloat("prezzo_totale"));
				prenotazione.setDescrizione(rs.getString("descrizione"));
				prenotazione.setDataPrenotazione(String.valueOf(rs.getDate("data_prenotazione")));
				prenotazione.setDataInizio(String.valueOf(rs.getDate("data_inizio")));
				prenotazione.setDataFine(String.valueOf(rs.getDate("data_fine")));
				prenotazione.setUsernameCliente(rs.getString("username_cliente"));
				prenotazione.setNomeLido(rs.getString("nome_lido"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return prenotazione;
	}

	@Override
	public Prenotazione findLastPrenotazione(String cliente) {
		Prenotazione prenotazione = null;
		String query = "SELECT *" +
				" FROM prenotazione" +
				" WHERE username_cliente = ? order by id_prenotazione desc limit 1;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, cliente);
			rs = st.executeQuery();
			if(rs.next()) {
				prenotazione = new Prenotazione();
				prenotazione.setIdPrenotazione(rs.getLong("id_prenotazione"));
				prenotazione.setPrezzoTotale(rs.getFloat("prezzo_totale"));
				prenotazione.setDescrizione(rs.getString("descrizione"));
				prenotazione.setDataPrenotazione(String.valueOf(rs.getDate("data_prenotazione")));
				prenotazione.setDataInizio(String.valueOf(rs.getDate("data_inizio")));
				prenotazione.setDataFine(String.valueOf(rs.getDate("data_fine")));
				prenotazione.setUsernameCliente(rs.getString("username_cliente"));
				prenotazione.setNomeLido(rs.getString("nome_lido"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return prenotazione;
	}

	@Override
	public List<Prenotazione> findByUsername(String username) {
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		String query = "SELECT * FROM prenotazione WHERE username_cliente=?;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, username);
			rs = st.executeQuery();
			while(rs.next()) {
				Prenotazione prenotazione = new Prenotazione();
				prenotazione.setIdPrenotazione(rs.getLong("id_prenotazione"));
				prenotazione.setPrezzoTotale(rs.getFloat("prezzo_totale"));
				prenotazione.setDescrizione(rs.getString("descrizione"));
				prenotazione.setDataPrenotazione(String.valueOf(rs.getDate("data_prenotazione")));
				prenotazione.setDataInizio(String.valueOf(rs.getDate("data_inizio")));
				prenotazione.setDataFine(String.valueOf(rs.getDate("data_fine")));
				prenotazione.setNomeLido(rs.getString("nome_lido"));
				prenotazioni.add(prenotazione);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return prenotazioni;
	}
	
	@Override
	public List<Prenotazione> findByLido(String nomeLido) {
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		String query = "SELECT * FROM prenotazione WHERE nome_lido=?;";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, nomeLido);
			rs = st.executeQuery();
			while(rs.next()) {
				Prenotazione prenotazione = new Prenotazione();
				prenotazione.setIdPrenotazione(rs.getLong("id_prenotazione"));
				prenotazione.setPrezzoTotale(rs.getFloat("prezzo_totale"));
				prenotazione.setDescrizione(rs.getString("descrizione"));
				prenotazione.setDataPrenotazione(String.valueOf(rs.getDate("data_prenotazione")));
				prenotazione.setDataInizio(String.valueOf(rs.getDate("data_inizio")));
				prenotazione.setDataFine(String.valueOf(rs.getDate("data_fine")));
				prenotazione.setUsernameCliente(rs.getString("username_cliente"));
				prenotazioni.add(prenotazione);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(st);
		}
		return prenotazioni;
	}

	@Override
	public boolean save(Prenotazione prenotazione) {
		prenotazione.setIdPrenotazione(IdBroker.getId(conn));
		String query = "INSERT INTO prenotazione(id_prenotazione, prezzo_totale, descrizione, data_prenotazione, data_inizio, "
				+ "data_fine, username_cliente, nome_lido) VALUES(?,?,?,?,?,?,?,?);";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.setLong(1, prenotazione.getIdPrenotazione());
			st.setFloat(2, prenotazione.getPrezzoTotale());
			st.setString(3, prenotazione.getDescrizione());
			st.setDate(4, Date.valueOf(prenotazione.getDataPrenotazione()));
			st.setDate(5, Date.valueOf(prenotazione.getDataInizio()));
			st.setDate(6, Date.valueOf(prenotazione.getDataFine()));
			st.setString(7, prenotazione.getUsernameCliente());
			st.setString(8, prenotazione.getNomeLido());
			st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeStatement(st);
		}
		return true;
	}

	@Override
	public boolean delete(Prenotazione prenotazione) {
		long id = prenotazione.getIdPrenotazione();
		String query = "DELETE FROM prenotazione WHERE id_prenotazione=?;";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.setLong(1, id);
			st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeStatement(st);
		}
		return true;
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
}
