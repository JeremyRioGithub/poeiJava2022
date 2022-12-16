package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
@Entity
@IdClass(PersonnePK.class) // Personne Primary Key
public class PersonneWithPK implements Serializable{
    private String prenom;
    private String nom;
    @Id
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Id
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private static final long serialVersionUID = 1L;

    public PersonneWithPK(){super();}
}
