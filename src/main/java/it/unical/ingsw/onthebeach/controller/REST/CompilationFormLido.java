package it.unical.ingsw.onthebeach.controller.REST;

import it.unical.ingsw.onthebeach.Database;
import it.unical.ingsw.onthebeach.model.Lido;
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

@RestController
public class CompilationFormLido {


    @PostMapping("InsertLido")
    public String aggiungiLido(HttpServletRequest req, HttpServletResponse resp, @RequestParam("foto") MultipartFile file, String nome, String usernameGestore, String posizione, String numero, String email, int numeroOmbrelloni, String descrizione) throws SQLException, IOException {


        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2",
                    "postgres", "root");

            Statement st = conn.createStatement();

            if (Database.getInstance().getLidoDao().saveOrUpdate(new Lido(nome, posizione, numero, email, descrizione, file.getBytes(), numeroOmbrelloni, usernameGestore))) {
                /* la creazione degli ombrelloni non va, int numOmbrelloni da un piccolo errore
                for (int i = 0; i < numeroOmbrelloni; i++) {
                    Ombrellone ombrellone = new Ombrellone();
                    Database.getInstance().getOmbrelloneDao().saveOrUpdate(ombrellone);
                }
                 */
                resp.sendRedirect("index");
                return "registrazioneLidoEffettuata";
            } else
                return "ERRORE";
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            resp.sendRedirect("pageForm");
            return "error";
        }
    }
}
