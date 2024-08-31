package com.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "index"; // Esto debe mapear a src/main/resources/templates/index.html
    }
}
