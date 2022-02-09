package it.unical.ingsw.onthebeach.controller.REST;

import it.unical.ingsw.onthebeach.Database;
import it.unical.ingsw.onthebeach.model.Lido;
import it.unical.ingsw.onthebeach.model.Ombrellone;
import it.unical.ingsw.onthebeach.model.Utente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

@RestController
public class ProfileREST {

    @PostMapping("/updateInfoUtente")
    public String modificaInfoUtente(HttpServletRequest req, HttpServletResponse resp, String nome, String cognome, String email) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
                    "postgres", "root");

            Utente utente = Database.getInstance().getUtenteDao().findByPrimaryKey((String) req.getSession().getAttribute("username"));

            if(nome!=null){
                if (!nome.isEmpty()) {
                    utente.setNome(nome);
                }
            }
            if(cognome!=null){
                if (!cognome.isEmpty()) {
                    utente.setCognome(cognome);
                }
            }
            if(email!=null){
                if(!email.isEmpty()) {
                    utente.setEmail(email);
                }
            }

            if (Database.getInstance().getUtenteDao().update(utente)) {
                return "Update Completato";
            } else {
                return "Error";}

        } catch (SQLException e) {
            resp.setStatus(500);
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping("/updateInfoLido")
    public String modificaInfoLido(HttpServletRequest req, HttpServletResponse resp, String telefono, String email, String descrizione, Integer numOmbrelloni, @RequestParam("foto") MultipartFile file) throws SQLException {


        try {


            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
                    "postgres", "root");

            Lido lido = Database.getInstance().getLidoDao().findByGestore((String) req.getSession().getAttribute("username"));


            Statement st = conn.createStatement();

            if(telefono!=null){
                if(!telefono.isEmpty()) {
                    lido.setNumero(telefono);
                }
            }
            if(email!=null){
                if(!email.isEmpty()) {
                    lido.setEmail(email);
                }
            }
            if(descrizione!=null){
                if(!descrizione.isEmpty()) {
                    lido.setDescrizione(descrizione);
                }
            }
            if(!(numOmbrelloni ==null)){
                if(numOmbrelloni>lido.getNumeroOmbrelloni()){
                    int temp=numOmbrelloni-lido.getNumeroOmbrelloni();
                    for (int i = 0; i < temp; i++) {
                        Database.getInstance().getOmbrelloneDao().saveOrUpdate(new Ombrellone(0,false, lido.getNome(), 2));
                    }
                }
                if(numOmbrelloni<lido.getNumeroOmbrelloni()){
                    int temp=lido.getNumeroOmbrelloni()-numOmbrelloni;
                    List<Ombrellone> ombrelloni = Database.getInstance().getOmbrelloneDao().findByLido(lido.getNome());
                    Collections.reverse(ombrelloni);
                    for (int i = 0; i < temp; i++) {
                        Database.getInstance().getOmbrelloneDao().delete(ombrelloni.get(i));
                    }

                }
                lido.setNumeroOmbrelloni(numOmbrelloni);
            }
            if(file!=null){
                if(!file.isEmpty()) {
                    lido.setFoto(file.getBytes());
                }
            }


            if (Database.getInstance().getLidoDao().saveOrUpdate(lido)) {
                return "Update Completato";
            } else {
                return "Error";}

        } catch (SQLException | IOException e) {
            resp.setStatus(500);
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping("/cambiaPassword")
    public String cambiaPassword(HttpServletRequest req, HttpServletResponse resp, String password, String newpassword) throws SQLException {

        Utente utente = Database.getInstance().getUtenteDao().findByPrimaryKey((String) req.getSession().getAttribute("username"));

        if(!utente.getPassword().equals(password)) {
            return "passwordErrata";
        } else if(Database.getInstance().getUtenteDao().setPassword((String) req.getSession().getAttribute("username"),newpassword)){
            return null;
        }
        else return "modificheErrate";

        /*Database

            String sql = "UPDATE utente SET password = ? WHERE username = ?;";

            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "postgres");

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, newpassword);

            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        //Database.getInstance().getUtenteDao().setPassword((String) req.getSession().getAttribute("username"), newpassword);
    }

    @PostMapping("/promozione")
    public String promozioneUtente(String username) throws SQLException {
        System.out.println(username);
        if(Database.getInstance().getUtenteDao().setAdmin(username))
            return "utentePromosso";

        return "errore";
    }

    @PostMapping("/rimozione")
    public String rimozioneUtente(String username) throws SQLException {
        System.out.println(username);
        if(Database.getInstance().getUtenteDao().delete(username))
            return "utenteRimosso";

        return "errore";
    }
}

