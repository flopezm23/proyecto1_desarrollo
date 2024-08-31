package com.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Esto debería corresponder a un archivo en src/main/resources/templates/login.html
    }
}

