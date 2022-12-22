package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
public class Produit {
    @Id
    @GeneratedValue
    private int id;
    private String marque;
    private String reference;
    private double prix;
    private int stock;
}