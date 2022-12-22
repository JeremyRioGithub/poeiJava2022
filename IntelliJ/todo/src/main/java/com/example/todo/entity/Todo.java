package com.example.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String titre;
    private String description;
    private boolean etat;

    public boolean getEtat() {
        return(this.etat);
    }
}