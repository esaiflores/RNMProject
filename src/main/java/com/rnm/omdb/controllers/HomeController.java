package com.rnm.omdb.controllers;


import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {


    @GetMapping("/")
    public String welcome() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/movie")
    public String movie() {
        return "movie";
    }

    @GetMapping("/favorites")
    public String favorites() { return "favorites";}


}