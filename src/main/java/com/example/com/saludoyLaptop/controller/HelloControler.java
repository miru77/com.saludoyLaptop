package com.example.com.saludoyLaptop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Ejercicio 1
@RestController
public class HelloControler {
    @GetMapping("/saludo")
    public String saludo(){
        return "Hola java Spring";
    }

}
