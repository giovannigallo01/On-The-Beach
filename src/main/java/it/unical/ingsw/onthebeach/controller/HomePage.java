package it.unical.ingsw.onthebeach.controller;

import it.unical.ingsw.onthebeach.Database;
import it.unical.ingsw.onthebeach.model.Lido;
import it.unical.ingsw.onthebeach.model.Ombrellone;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePage {
    @GetMapping({"/", "/index"})
    public String homePage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, UnsupportedEncodingException {

        List<Lido> allLidi = Database.getInstance().getLidoDao().findAll();
        List<Lido> primiTre = new ArrayList<>();
        for(int i=0; i<3; ++i) {
            primiTre.add(allLidi.get(i));
        }
        req.setAttribute("lidi", primiTre);


        List<Ombrellone> allOmbrelloni = Database.getInstance().getOmbrelloneDao().findAll();
        List<Ombrellone> primiTreOmbrelloni = new ArrayList<>();
        for(Lido l : primiTre) {
            for(Ombrellone o : allOmbrelloni)
                if(l.getNome().equals(o.getNomeLido()))
                    primiTreOmbrelloni.add(o);
        }
        req.setAttribute("ombrelloni", primiTreOmbrelloni);


        List<String> fotoLidi = new ArrayList<>();
        for(Lido l : primiTre) {
            byte[] encodeBase64 = Base64.encodeBase64(l.getFoto());
            System.out.println("Homepage foto: " + l.getNome());
            fotoLidi.add(new String(encodeBase64, "UTF-8"));
        }
        req.setAttribute("fotoLidi", fotoLidi);

        return "index";
    }
}
