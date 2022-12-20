package org.example.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Compte {
    @Id
    private int id;

    private String libelle;

    @ManyToOne
    @JoinColumn(name="AGENCE_ID")
    private Agence agence;

    @ManyToMany
    @JoinTable(name= "COMPTE_CLIENT",
            joinColumns = @JoinColumn(name= "COMPTE_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name= "CLIENT_ID", referencedColumnName = "id"))
    private Collection<Client> clients;
}
