package org.example.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name= "agence")
public class Agence {
    @Id
    //@GeneratedValue
    private int id;

    private String adresse;

    @OneToMany(mappedBy = "agence")
    private Collection<Compte> comptes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
