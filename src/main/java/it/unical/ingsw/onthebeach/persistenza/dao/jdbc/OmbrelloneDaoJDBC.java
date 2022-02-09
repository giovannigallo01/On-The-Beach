package it.unical.ingsw.onthebeach.persistenza.dao.jdbc;

import it.unical.ingsw.onthebeach.model.Ombrellone;
import it.unical.ingsw.onthebeach.persistenza.dao.OmbrelloneDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OmbrelloneDaoJDBC implements OmbrelloneDao{
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
            "postgres", "root");
    public OmbrelloneDaoJDBC(Connection conn) throws SQLException {
        this.conn=conn;
    }

    @Override
    public boolean saveOrUpdate(Ombrellone ombrellone) {
        PreparedStatement st = null;
        if (ombrellone.getIdOmbrellone() == 0) {
            //INSERT
            try {
                ombrellone.setIdOmbrellone(IdBroker.getId(conn));
                String query = "insert into ombrellone "
                        + "values (?, ?, ?, ?)";
                st = conn.prepareStatement(query);
                st.setLong(1, ombrellone.getIdOmbrellone());
                st.setBoolean(2, ombrellone.getOccupato());
                st.setFloat(3, ombrellone.getPrezzo());
                st.setString(4, ombrellone.getNomeLido());

                st.executeUpdate();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }else {
            //UPDATE
            try {
                String query = "update ombrellone "
                        + "set occupato = ?, nome_lido = ?, prezzo = ?"
                        + "where id_ombrellone = ?";
                st = conn.prepareStatement(query);
                st.setBoolean(1, ombrellone.getOccupato());
                st.setString(2, ombrellone.getNomeLido());
                st.setFloat(3, ombrellone.getPrezzo());
                st.setLong(4, ombrellone.getIdOmbrellone());

                st.executeUpdate();

            } catch (SQLException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Ombrellone findByPrimaryKey(long id) {
        Ombrellone o = null;
        String query = "select * from ombrellone where id_ombrellone = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                o = new Ombrellone();
                o.setIdOmbrellone(rs.getLong("id_ombrellone"));
                o.setOccupato(rs.getBoolean("occupato"));
                o.setNomeLido(rs.getString("nome_lido"));
                o.setPrezzo(rs.getFloat(("prezzo")));
                st.executeUpdate();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();}
        return o;
    }


    @Override
    public List<Ombrellone> findByLido(String nome) {
        List<Ombrellone> ombrelloni = new ArrayList<Ombrellone>();
        String query = "select * from ombrellone where nome_lido = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,nome);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Ombrellone o = new Ombrellone();
                o.setIdOmbrellone(rs.getLong("id_ombrellone"));
                o.setOccupato(rs.getBoolean("occupato"));
                o.setPrezzo(rs.getFloat(("prezzo")));
                o.setNomeLido(rs.getString("nome_lido"));
                ombrelloni.add(o);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();}
        return ombrelloni;
    }

    @Override
    public boolean delete(Ombrellone ombrellone) {
        try {
            String query = "delete from ombrellone "
                    + "where id_ombrellone = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, ombrellone.getIdOmbrellone());
            st.executeUpdate();
        } catch (SQLException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean switchOccupato(Ombrellone ombrellone) {
            try {
                String query = "update ombrellone "
                        + "set occupato = ? "
                        + "where id_ombrellone = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setBoolean(1, !ombrellone.getOccupato());
                st.setLong(2, ombrellone.getIdOmbrellone());

                st.executeUpdate();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            return true;
    }
    @Override
    public List<Ombrellone> findAll() {
        List<Ombrellone> ombrelloni = new ArrayList<Ombrellone>();
        String query = "select * from ombrellone";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Ombrellone o = new Ombrellone();
                o.setIdOmbrellone(rs.getLong("id_ombrellone"));
                o.setOccupato(rs.getBoolean("occupato"));
                o.setNomeLido(rs.getString("nome_lido"));
                o.setPrezzo(rs.getFloat(("prezzo")));
                ombrelloni.add(o);
            }
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();}
        return ombrelloni;
    }


}