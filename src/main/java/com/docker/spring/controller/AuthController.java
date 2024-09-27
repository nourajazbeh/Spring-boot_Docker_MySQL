package com.docker.spring.controller;

import com.docker.spring.model.Person;
import com.docker.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private PersonService personService;

    @GetMapping("/login")
    public String login() {
        return "login"; // Rückgabe der Login-Seite
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam String username, @RequestParam String password, Model model) {
        Person person = personService.authenticate(username, password);
        if (person != null) {
            model.addAttribute("user", person);
            return "home"; // Erfolgreiche Authentifizierung, Weiterleitung zur Startseite
        }
        model.addAttribute("error", "Ungültige Anmeldeinformationen");
        return "login"; // Fehlerhafte Anmeldeinformationen, Rückgabe zur Login-Seite
    }
}
