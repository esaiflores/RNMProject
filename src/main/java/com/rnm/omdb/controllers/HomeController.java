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

    @GetMapping("/sign-up")
    public String showSignupForm() {
        return "/sign-up";
    }
}