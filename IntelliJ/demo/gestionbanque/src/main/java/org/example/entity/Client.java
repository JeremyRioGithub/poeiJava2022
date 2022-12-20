package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name= "clients")
public class Client {
    @Id
    private int id;
    private String nom;

    private String prenom;

    @ManyToMany(mappedBy = "clients")
    private Collection<Compte> comptes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
