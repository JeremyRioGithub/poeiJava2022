package com.example.demosogetisecurity.controller;

import com.example.demosogetisecurity.model.Cards;
import com.example.demosogetisecurity.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam int id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }
    @GetMapping("/myCards")
    public String getCardsDetails(){
        return "Bienvenue dans le detail du Cards.";
    }
}
