package com.proyecto1.controller;


import com.proyecto1.service.MarcacionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarcacionController {

    @Autowired
    private MarcacionService marcacionService;

    // Métodos del controlador
}