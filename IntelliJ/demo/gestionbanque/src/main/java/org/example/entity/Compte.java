package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name= "comptes")
public class Compte {
    @Id
    private int id;

    private String libelle;

    @ManyToOne
    @JoinColumn(name="AGENCE_ID")
    private Agence agence;

    @ManyToMany
    @JoinTable(name= "compte_client",
            joinColumns = @JoinColumn(name= "COMPTE_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name= "CLIENT_ID", referencedColumnName = "id"))
    private Collection<Client> clients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }
}
