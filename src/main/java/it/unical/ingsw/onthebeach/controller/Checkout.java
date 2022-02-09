package it.unical.ingsw.onthebeach.controller;

import it.unical.ingsw.onthebeach.Database;
import it.unical.ingsw.onthebeach.model.Prenotazione;
import it.unical.ingsw.onthebeach.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
public class Checkout {

    @GetMapping("/checkout")
    public String paginaCheckout(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

        Utente utente = Database.getInstance().getUtenteDao().findByPrimaryKey((String) req.getSession().getAttribute("username"));
        req.setAttribute("utenteCheckOut", utente);

        Prenotazione prenotazione = Database.getInstance().getPrenotazioneDao().findLastPrenotazione((String) req.getSession().getAttribute("username"));
        req.setAttribute("prenotazioneCheckOut", prenotazione);

        return "checkout";
    }

}
