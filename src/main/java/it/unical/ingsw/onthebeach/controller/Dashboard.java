package it.unical.ingsw.onthebeach.controller;

import it.unical.ingsw.onthebeach.Database;
import it.unical.ingsw.onthebeach.model.Lido;
import it.unical.ingsw.onthebeach.model.Prenotazione;
import it.unical.ingsw.onthebeach.model.Recensione;
import it.unical.ingsw.onthebeach.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class Dashboard {

    @GetMapping("/profile")
    public String paginaProfilo(HttpServletRequest req) throws SQLException {
        if(req.getSession().getAttribute("username") != null) {
            //System.out.println(req.getSession().getAttribute("username"));
            Utente utente = Database.getInstance().getUtenteDao().findByPrimaryKey((String) req.getSession().getAttribute("username"));
            req.setAttribute("utente", utente);

            Lido lido = Database.getInstance().getLidoDao().findByGestore((String) req.getSession().getAttribute("username"));
            req.setAttribute("lido", lido);

            List<Utente> utentiCliente = Database.getInstance().getUtenteDao().findAllFromTipoUtente("Cliente");
            for(Utente u : utentiCliente) {
                System.out.println(u.getUsername());
            }
            req.setAttribute("utenteCliente", utentiCliente);
            List<Prenotazione> prenotazioni = Database.getInstance().getPrenotazioneDao().findByUsername((String) req.getSession().getAttribute("username"));
            req.setAttribute("prenotazioni", prenotazioni);

            List<Recensione> recensioni = Database.getInstance().getRecensioneDao().findByUtente(utente.getUsername());
            req.setAttribute("recensioni", recensioni);

            return "dashboard";
        }

        return "nonAutorizzato";
    }

    @GetMapping("/promozioneg")
    public String paginaProfiloPromozione(HttpServletRequest req) throws SQLException {
        if(req.getSession().getAttribute("username") != null) {
            //System.out.println(req.getSession().getAttribute("username"));
            Utente utente = Database.getInstance().getUtenteDao().findByPrimaryKey((String) req.getSession().getAttribute("username"));
            req.setAttribute("utente", utente);

            Lido lido = Database.getInstance().getLidoDao().findByGestore((String) req.getSession().getAttribute("username"));
            req.setAttribute("lido", lido);

            List<Utente> utentiCliente = Database.getInstance().getUtenteDao().findAllFromTipoUtente("Cliente");
            for(Utente u : utentiCliente) {
                System.out.println(u.getUsername());
            }
            req.setAttribute("utenteCliente", utentiCliente);
            List<Prenotazione> prenotazioni = Database.getInstance().getPrenotazioneDao().findByUsername((String) req.getSession().getAttribute("username"));
            req.setAttribute("prenotazioni", prenotazioni);

            List<Recensione> recensioni = Database.getInstance().getRecensioneDao().findByUtente(utente.getUsername());
            req.setAttribute("recensioni", recensioni);

            Database.getInstance().getUtenteDao().setAdmin((String) req.getAttribute("usrCliente"));

            return "dashboard";
        }

        return "nonAutorizzato";
    }
/*
    @GetMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("login");
    }
*/
}
