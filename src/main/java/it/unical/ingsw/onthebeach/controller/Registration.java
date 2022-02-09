package it.unical.ingsw.onthebeach.controller;

import it.unical.ingsw.onthebeach.Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@Controller
public class Registration {

    @GetMapping("/registration")
    public String paginaRegistrazione() {
        return "registrationPage";
    }
/*
    @PostMapping("/registrationServices")
    public String registrati(HttpServletRequest req, HttpServletResponse resp, String nome, String email, String username, String passw) throws ServletException, IOException {

        //sql aggiunta di un utente nel database

        String sql = "insert into utente (username, nome, email, password, tipo_utente) values ('"+ username +"','"+ nome +"','"+ email +"','"+ passw +"','"+ 0 +"');";

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2", "postgres", "root");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                resp.sendRedirect("login");
            }
            else
                return "registration";
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            resp.sendRedirect("login");
        }

        return null;

    }
    */

}
