package it.unical.ingsw.onthebeach.controller;

import it.unical.ingsw.onthebeach.Database;
import it.unical.ingsw.onthebeach.model.Lido;
import it.unical.ingsw.onthebeach.model.Ombrellone;
import it.unical.ingsw.onthebeach.model.Recensione;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Product {

    @GetMapping("/product")
    public String paginaProdotti(HttpServletRequest req) throws SQLException, IOException {
        /*if (req.getSession().getAttribute("username") != null) {
            //System.out.println(req.getSession().getAttribute("nome"));
            Lido lido = Database.getInstance().getLidoDao().findByPrimaryKey((String) req.getSession().getAttribute("nome"));
            req.setAttribute("lido", lido);

            return "products";
        }*/

        String nomeLido = req.getParameter("lido");
        System.out.println("nome lido: " + nomeLido);
        Lido lido = Database.getInstance().getLidoDao().findByPrimaryKey(nomeLido);

        if(lido == null)
            return "notFound";


        byte[] encodeBase64 = Base64.encodeBase64(lido.getFoto());
        String base64Encoded = new String(encodeBase64, "UTF-8");

        /*
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(lido.getFoto());
        BufferedImage newImage = ImageIO.read(inStreambj);
        File foto2 = new File("outputImage.jpg");
        ImageIO.write(newImage, "jpg", foto2 );*/

        req.setAttribute("lido", lido);
        req.setAttribute("foto", base64Encoded);
        //System.out.println(lido.getNome());
        List<Recensione> recensioni = Database.getInstance().getRecensioneDao().findByLido(nomeLido);
        req.setAttribute("recensioni", recensioni);
        for(Recensione r : recensioni){
            System.out.println(r.getTesto());
        }

        List<Ombrellone> ombrelloni = Database.getInstance().getOmbrelloneDao().findByLido(nomeLido);
        req.setAttribute("ombrelloni", ombrelloni);
        for(Ombrellone o : ombrelloni){
            System.out.println(o.getIdOmbrellone());
        }

        /*List<List<Integer> > stelle = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for(Recensione s : recensioni) {
            for (int i = 0; i < s.getStar(); ++i) {
                tmp.add(1);
            }

            stelle.add(tmp);
            tmp.clear();
        }
        req.setAttribute("stelle", stelle);*/



        return "products";
        //return "nonAutorizzato";
    }


    @RequestMapping("/imgPath1/{param1}")
    public void profilo(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ServletException, IOException {

        String username = (String) req.getSession().getAttribute("username");



        byte[]img= Database.getInstance().getLidoDao().trovaImmagine(username);
        res.setContentType("image/jpeg");
        res.setContentLength(img.length); // imageBytes - image in bytes
        res.getOutputStream().write(img);
        res.getOutputStream().flush();
        res.getOutputStream().close();

    }


}


