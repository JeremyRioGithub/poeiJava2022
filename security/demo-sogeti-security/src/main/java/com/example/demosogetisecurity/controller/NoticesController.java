package com.example.demosogetisecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
    @GetMapping("/myNotices")
    public String getNoticesDetails(){
        return "Bienvenue dans le detail du Notices.";
    }
}
