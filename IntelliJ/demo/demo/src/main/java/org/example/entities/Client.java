package org.example.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {
    @Id
    private int id;
    private String nom;

    private String prenom;

    @ManyToMany(mappedBy = "clients")
    private Collection<Compte> comptes;

}
