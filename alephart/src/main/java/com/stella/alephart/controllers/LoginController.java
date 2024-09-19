package com.stella.alephart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";  // Aquí puedes definir tu propia vista de login si lo deseas
    }

    @GetMapping("/principal")
    public String home(Model model, OidcUser oidcUser) {
        if (oidcUser != null) {
            model.addAttribute("userName", oidcUser.getFullName());
        }
        return "home";  // Vista donde redirige tras el login
    }
}