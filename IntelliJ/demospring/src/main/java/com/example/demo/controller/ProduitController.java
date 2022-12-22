package com.example.demo.controller;

import com.example.demo.entity.Produit;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produit")
@ResponseBody
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @PostMapping("")
    public Produit postProduit(@RequestBody Produit produit){
        if(produitService.create(produit)) {
            System.out.println("created: ID:"+produit.getId());
            return produit;
        }
        return null;
    }

    @PostMapping("/update/{id}")
    public Produit updateProduit(@PathVariable("id") int id, @RequestBody Produit produit){
        Produit produitFound = produitService.findById(id);
        if(produitFound != null) {
            System.out.println("updated: beforeMarque"+produitFound.getMarque()+" to afterMarque:"+produit.getMarque());
            produitFound.setMarque(produit.getMarque());
            produitFound.setReference(produit.getReference());
            produitFound.setPrix(produit.getPrix());
            produitFound.setStock(produit.getStock());
            produitService.update(produitFound);
            return produitFound;
        }
        return null;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") int id){
        Produit produitFound = produitService.findById(id);
        if(produitFound != null && produitService.delete(produitFound)) {
            return "deleted: ID:"+produitFound.getId();
        }
        return "Produit with id:"+id+" not found !";
    }

    @GetMapping("/find/{id}")
    public Produit findByIdProduitPath(@PathVariable("id") int id){
        Produit produit = produitService.findById(id);
        System.out.println("found with PathVariable: ID:"+produit.getId());
        return produit;
    }
    @GetMapping("/find")
    public Produit findByIdProduit(@RequestParam("id") int id){
        Produit produit = produitService.findById(id);
        System.out.println("found with RequestParam: ID:"+produit.getId());
        return produit;
    }

    @GetMapping("/findall")
    public List<Produit> findAllProduit(){
        return produitService.findAll();
    }

}