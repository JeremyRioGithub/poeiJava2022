package org.example.entities;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Agence {
    @Id
    private int id;

    private String adresse;

    @OneToMany(mappedBy = "agence")
    private Collection<Compte> comptes;
}
