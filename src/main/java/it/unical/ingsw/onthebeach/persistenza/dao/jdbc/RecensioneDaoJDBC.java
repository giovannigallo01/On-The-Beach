package it.unical.ingsw.onthebeach.persistenza.dao.jdbc;

import it.unical.ingsw.onthebeach.model.Recensione;
import it.unical.ingsw.onthebeach.persistenza.dao.RecensioneDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDaoJDBC implements RecensioneDao {
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
            "postgres", "root");

    public RecensioneDaoJDBC(Connection conn) throws SQLException {
        this.conn = conn;
    }


    @Override
    public List<Recensione> findAll() {
        List<Recensione> recensioni = new ArrayList<Recensione>();
        String query = "select * from recensione";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Recensione r = new Recensione();
                r.setIdRecensione(rs.getLong("id_recensione"));
                r.setTesto(rs.getString("testo"));
                r.setUsernameCliente(rs.getString("username_cliente"));
                r.setIdPrenotazione(rs.getLong("id_prenotazione"));
                r.setStar(rs.getInt("star"));
                recensioni.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return recensioni;
    }

    @Override
    public Recensione findByPrimaryKey(long id) {
        Recensione r = null;
        String query = "select * from recensione where id_recensione = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                r = new Recensione();
                r.setTesto(rs.getString("testo"));
                r.setUsernameCliente(rs.getString("cognome"));
                r.setIdPrenotazione(rs.getLong("id_prenotazione"));
                r.setIdRecensione(rs.getLong("id_recensione"));
                r.setStar(rs.getInt("star"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Recensione findByPrenotazione(long id) {
        Recensione r = null;
        String query = "select * from recensione where id_prenotazione = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                r = new Recensione();
                r.setTesto(rs.getString("testo"));
                r.setUsernameCliente(rs.getString("cognome"));
                r.setIdPrenotazione(rs.getLong("id_prenotazione"));
                r.setIdRecensione(rs.getLong("id_recensione"));
                r.setStar(rs.getInt("star"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public List<Recensione> findByUtente(String username) {
        List<Recensione> recensioni = new ArrayList<Recensione>();
        String query = "select * from recensione where username_cliente = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Recensione r = new Recensione();
                r.setTesto(rs.getString("testo"));
                r.setUsernameCliente(rs.getString("username_cliente"));
                r.setIdPrenotazione(rs.getLong("id_prenotazione"));
                r.setIdRecensione(rs.getLong("id_recensione"));
                r.setStar(rs.getInt("star"));
                recensioni.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return recensioni;
    }


    @Override
    public List<Recensione> findByLido(String nome) {
        List<Recensione> recensioni = new ArrayList<Recensione>();

        String query = "select r.id_recensione, r.testo,r.username_cliente,r.id_prenotazione, r.star" +
                " from recensione r, prenotazione p" +
                " where p.nome_lido = ? and r.id_prenotazione=p.id_prenotazione";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Recensione r = new Recensione();
                r.setIdRecensione(rs.getLong("id_recensione"));
                r.setTesto(rs.getString("testo"));
                r.setUsernameCliente(rs.getString("username_cliente"));
                r.setIdPrenotazione(rs.getLong("id_prenotazione"));
                r.setStar(rs.getInt("star"));
                recensioni.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return recensioni;
    }

    @Override
    public boolean saveOrUpdate(Recensione recensione) {
        if (recensione.getIdRecensione() == 0) {
            //INSERT
            try {
                recensione.setIdRecensione(IdBroker.getId(conn));
                String query = "insert into recensione "
                        + "values (?, ?, ?, ?,?)";
                PreparedStatement st = conn.prepareStatement(query);
                st.setLong(1, recensione.getIdRecensione());
                st.setString(2, recensione.getTesto());
                st.setInt(3, recensione.getStar());
                st.setString(4, recensione.getUsernameCliente());
                st.setLong(5, recensione.getIdPrenotazione());

                st.executeUpdate();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        } else {
            //UPDATE
            try {
                String query = "update recensione "
                        + "set testo = ?, star = ?, username_cliente = ?, id_prenotazione = ? "
                        + "where id_recensione = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, recensione.getTesto());
                st.setInt(2, recensione.getStar());
                st.setString(3, recensione.getUsernameCliente());
                st.setLong(4, recensione.getIdPrenotazione());
                st.setLong(5, recensione.getIdRecensione());

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
    public boolean delete(Recensione recensione) {
        try {
            String query = "delete from recensione "
                    + "where id_recensione = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, recensione.getIdRecensione());
            st.executeUpdate();
        } catch (SQLException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public boolean updateText(Recensione recensione) {
        try {
            String query = "update recensione "
                    + "set testo = ?"
                    + "where id_recensione = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, recensione.getTesto());
            st.setLong(2, recensione.getIdRecensione());
            st.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        // TODO Auto-generated method stub
        return true;
    }
}