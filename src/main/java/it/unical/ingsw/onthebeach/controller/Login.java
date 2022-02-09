package it.unical.ingsw.onthebeach.controller;

import it.unical.ingsw.onthebeach.Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@Controller
public class Login {
    @GetMapping("/login")
    public String paginaLogin() {
        return "loginPage";
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("login");
    }

    @PostMapping("/loginServices")
    public String faiLogin(HttpServletRequest req, HttpServletResponse resp, String username, String password) throws IOException {

        String sql = "SELECT * FROM utente WHERE username = '"+ username +"' and password = '"+ password +"'";
        HttpSession session = req.getSession(true);

        //ERRORE: la relazione "utente" non esiste
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
                    "postgres", "root");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                session.setAttribute("username", rs.getString("username"));
                //System.out.println(rs.getString("username"));
                resp.sendRedirect("profile");

            } else {
                //System.out.println("Debug");
                resp.sendRedirect("login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("login");
        }

        return null;
    }
}
