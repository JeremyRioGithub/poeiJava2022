package com.example.demosogetisecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/myContact")
    public String getContactDetails(){
        return "Bienvenue dans le detail du Contact.";
    }
}
