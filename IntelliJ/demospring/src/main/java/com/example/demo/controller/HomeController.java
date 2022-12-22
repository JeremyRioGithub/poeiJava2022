package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Homecontroler est spring beans de type controller
@ResponseBody // retour des methodes qui sera directement la reponse des requetes
public class HomeController {
    // http://localhost:8080/
    // Get et Post
    @RequestMapping("/")
    public String getHome(){return "Hello World!";}
    @RequestMapping("/toto")
    public String getToto(){return "Je suis Toto!";}
    @GetMapping("/get")
    public String pageGet(){return "une page avec du get";}
    @PostMapping("/post")
    public String pagePost(){return "une page avec du post";}
}
