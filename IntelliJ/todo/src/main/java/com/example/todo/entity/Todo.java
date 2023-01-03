package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String titre;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean etat;

    public boolean getEtat() {
        return(this.etat);
    }
}