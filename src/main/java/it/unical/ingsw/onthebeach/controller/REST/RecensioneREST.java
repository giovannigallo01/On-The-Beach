package it.unical.ingsw.onthebeach.controller.REST;

import it.unical.ingsw.onthebeach.Database;
import it.unical.ingsw.onthebeach.model.Recensione;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@RestController
public class RecensioneREST {

        /*
        @PostMapping("/updateRecensione")
        public String modificaRecensione(Long idRecensione,  String testo , HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {

String user= (String) req.getSession().getAttribute("username");
Long id;
Recensione rec = new Recensione();

                try {
                        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
                                "postgres", "root");
                        List<Recensione> recensioni= Database.getInstance().getRecensioneDao().findByUtente(user);
                       for (Recensione tmp: recensioni) {
                               if (tmp.getIdRecensione() == idRecensione) {
                                       rec = tmp;
                                       break;
                               }
                       }

                        Statement st = conn.createStatement();

                        if (Database.getInstance().getRecensioneDao().updateText(rec)) {

                                resp.sendRedirect("index");
                                return "modifica Recensione completata";
                        } else
                                return "ERRORE";
                }
                catch (SQLException | IOException e) {
                        e.printStackTrace();
                        resp.sendRedirect("profile");
                        return "error";
                }
        }*/

    @PostMapping("/updateRecensione")
    public String modificaRecensione(String idRecensione, String idPrenotazione, String testo, HttpServletRequest req) throws SQLException {

        Recensione rec = new Recensione(Long.parseLong(idRecensione), testo, 3, (String) req.getSession().getAttribute("username"), Long.parseLong(idPrenotazione));

        if(Database.getInstance().getRecensioneDao().saveOrUpdate(rec)) {
            return "updateCompletato";
        } else {
            return "error";
        }
    }
}

