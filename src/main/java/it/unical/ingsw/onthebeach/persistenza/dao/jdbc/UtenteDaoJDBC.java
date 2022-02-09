package it.unical.ingsw.onthebeach.persistenza.dao.jdbc;

import it.unical.ingsw.onthebeach.model.Utente;
import it.unical.ingsw.onthebeach.persistenza.dao.UtenteDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDaoJDBC implements UtenteDao {
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
            "postgres", "root");

    public UtenteDaoJDBC(Connection conn) throws SQLException {
        this.conn = conn;
    }

    @Override
    public List<Utente> findAll() {
        List<Utente> utenti = new ArrayList<Utente>();
        String query = "select * from utente";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Utente u = new Utente();
                u.setUsername(rs.getString("username"));
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setDataNascita(rs.getDate("data_nascita"));
                u.setTipoUtente(rs.getString("tipo_utente"));



                utenti.add(u);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return utenti;
    }

    @Override
    public Utente findByPrimaryKey(String username) {
        Utente utente = null;

        String query = "select * from utente where username = ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(query);
            st.setString(1,username);

            rs = st.executeQuery();
            if (rs.next()) {
                utente = new Utente();
                utente.setUsername(rs.getString("username"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setEmail(rs.getString("email"));
                utente.setPassword((rs.getString("password")));
                utente.setDataNascita(rs.getDate("data_nascita"));
                utente.setTipoUtente(rs.getString("tipo_utente"));


            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(username);
            e.printStackTrace();


        }


        return utente;
    }


    @Override
    public List<Utente> findAllFromTipoUtente(String tipoUtente) {
        List<Utente> utenti = new ArrayList<Utente>();
        String query = "select * from utente where tipo_utente = ?";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,tipoUtente);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Utente u = new Utente();
                u.setUsername(rs.getString("username"));
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setDataNascita(rs.getDate("data_nascita"));
                u.setTipoUtente(rs.getString("tipo_utente"));
                utenti.add(u);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return utenti;
    }


    @Override
    public boolean save(Utente utente) {
        //INSERT
        try {
            String query = "insert into utente "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, utente.getUsername());
            st.setString(2, utente.getNome());
            st.setString(3, utente.getCognome());
            st.setString(4, utente.getEmail());
            st.setString(5, utente.getPassword());
            st.setDate(6, utente.getDataNascita());
            st.setString(7, utente.getTipoUtente());
            st.setString(8, utente.getGenere());
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Utente utente) {
        //UPDATE
        try {
            String query = "update utente "
                    + "set nome = ?, cognome = ?, email = ?, password = ?, data_nascita = ?, tipo_utente=? "
                    + "where username = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, utente.getNome());
            st.setString(2, utente.getCognome());
            st.setString(3, utente.getEmail());
            st.setString(4, utente.getPassword());
            st.setDate(5, utente.getDataNascita());
            st.setString(6, utente.getTipoUtente());
            st.setString(7, utente.getUsername());

            st.executeUpdate();

        } catch (SQLException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String username) {
        try {
            String query = "delete from utente "
                    + "where username = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.executeUpdate();
        } catch (SQLException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean setPassword(String username, String password) {
        try {
            String query = "update utente "
                    + "set password = ?"
                    + "where username = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, password);
            st.setString(2, username);

            st.executeUpdate();

        } catch (SQLException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean setAdmin(String username) {
        try {
            String query = "update utente "
                    + "set tipo_utente = 'Amministratore Lido'"
                    + "where username = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);

            st.executeUpdate();

        } catch (SQLException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

}