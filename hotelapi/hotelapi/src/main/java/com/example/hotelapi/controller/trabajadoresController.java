package com.example.hotelapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trabajadores") // Define la ruta base para este controlador
public class trabajadoresController {

    @GetMapping("/all")
    public String getAllTrabajadores() {
        return "Trabajadores listados correctamente";
    }

}
