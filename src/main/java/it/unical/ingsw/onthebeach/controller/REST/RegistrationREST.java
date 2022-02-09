package it.unical.ingsw.onthebeach.controller.REST;

import it.unical.ingsw.onthebeach.Database;
import it.unical.ingsw.onthebeach.model.Utente;
import it.unical.ingsw.onthebeach.persistenza.dao.jdbc.UtenteDaoJDBC;
import org.postgresql.util.PSQLException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@RestController
public class RegistrationREST {

    @PostMapping("/registrationServices")
    public String registrati(HttpServletRequest req, HttpServletResponse resp, String nome,  String cognome, String email, String username, String password, String tipo_utente, Date dataNascita, String genere) throws ServletException, IOException, PSQLException {

        //sql aggiunta di un utente nel database

        //String sql = "insert into utente (username, nome, cognome, email, password, tipo_utente, data_nascita) values (" + "username" +", "+ nome +", "+ cognome +", "+ email +", "+ password + ", " + tipo_utente +", "+ dataNascita + ") ;";

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2", "postgres", "root");
            Utente temp = new Utente (username,nome,cognome,email,password, tipo_utente, dataNascita, genere);


            UtenteDaoJDBC utenteDaoJdbc = new UtenteDaoJDBC(conn);
            if(utenteDaoJdbc.save(temp)) {


                resp.sendRedirect("login");
                return "registrazioneEffettuata";
            } else {
                return "error";}
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            resp.sendRedirect("login");
            return "error";
        }
    }

    @PostMapping("/registrationServicesGoogle")
    public String registratiGoogle(HttpServletResponse resp, String username, String email, String nome) throws SQLException, IOException {

        Utente utente = new Utente(username, nome, null, email, null, "Cliente", null, null);
        if(Database.getInstance().getUtenteDao().save(utente)) {
            resp.sendRedirect("profile");
            return "registrazioneCompletata";
        }

        return "error";
    }
}
