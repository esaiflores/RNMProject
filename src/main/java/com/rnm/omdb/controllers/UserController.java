package com.rnm.omdb.controllers;

import com.rnm.omdb.models.User;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import repositories.UserRepository;

public class UserController {
    private UserRepository usersDao;

    public UserController(UserRepository usersDao) {
        this.usersDao = usersDao;

    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User newUser, @Validated User user, Errors validation, Model model){
        String username = user.getUsername();
        String email = user.getEmail();
        User userExists = usersDao.findByUsername(username);

        if (userExists != null) {
            validation.rejectValue("username", "user.username", username + " already exists in our records.");
        }

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "users/sign-up";
        }

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(newUser);
        return "redirect:/login";
    }
}
