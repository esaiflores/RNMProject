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

//These are the routes for the pages when navigating the application
    @GetMapping("/")
    public String welcome() {
        return "login";
    }

//   Ex: Whenever the application goes to /index it will then display the html file for index.html
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