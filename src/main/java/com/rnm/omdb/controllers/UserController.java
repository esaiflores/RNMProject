package com.rnm.omdb.controllers;

import com.rnm.omdb.daos.UsersRepository;
import com.rnm.omdb.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UsersRepository usersDao; // the users repo is going to be usersDao
    private PasswordEncoder passwordEncoder;

    public UserController(UsersRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao; // making that usersDao so it can be called easily
        this.passwordEncoder = passwordEncoder; // same as above
    }

    // this is the route for signup, but it creating a new user and adding the attribute of user so it can be found later when using spring
    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());// this is relating back to the User model
        return "/sign-up";//returning the sign-up.html
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User newUser, @Validated User user, Errors validation, Model model){
        String username = user.getUsername();
        User userExists = usersDao.findByUsername(username); //this is to validate their information

        if (userExists != null) {
            validation.rejectValue("username", "user.username", username + " already exists in our records."); // this is for duplicate usernames
        }
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "/sign-up";
        } // if something goes wrong the user does not get a random error page. but instead can be directed back to sign up
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(newUser);
        return "redirect:/";
    }// once everything checks out the user password is encoded and hashed for security, the user is saved and user is now directed back to login page
}
