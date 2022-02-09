package it.unical.ingsw.onthebeach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Form{
    @GetMapping("/pageForm")
    public String paginaForm() {
        return "pageForm";
    }
}
