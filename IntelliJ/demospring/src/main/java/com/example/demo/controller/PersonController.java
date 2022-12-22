package com.example.demo.controller;

import com.example.demo.entity.Personne;
import com.example.demo.interfaces.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/personne")
public class PersonController {

    @Autowired
    @Qualifier("personneService")
    private IPersonneService personneService;
    @GetMapping("")
    //public String getPersons(){return "Here is a list of persons";}
    public List<Personne> getPersons(){return personneService.getPersonnes();}

    @PostMapping("/post")
    public String postPerson(){return "I'm posting a person";}
    @GetMapping("/{id}")
    public String getOnePerson(@PathVariable Integer id){return "person id :" + id ;}

    @PostMapping("")
    public Personne postPerson(@RequestBody Personne personne){
        return personne;
    }

    /*@PostMapping("")
    public Personne postPerson(@RequestParam String nom, @RequestParam String prenom){
        return new Personne(1, nom, prenom);
    }*/
}
