package org.example;

import org.example.entity.Agence;
import org.example.entity.Client;
import org.example.entity.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercice");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        System.out.println("------------------------------");
        System.out.println("Ajout d'agence, clients et comptes");

        //Ajout d'une agence
        transac.begin();
        Agence agence = new Agence();
        agence.setId(1);
        agence.setAdresse("rue de la paix");
        em.persist(agence);
        transac.commit();

        //Ajout d'un client
        transac.begin();
        Client client = new Client();
        client.setId(1);
        client.setNom("NomClient");
        em.persist(client);
        transac.commit();

        //Ajout d'un deuxieme client
        transac.begin();
        Client client2 = new Client();
        client2.setId(2);
        client2.setNom("NomClient2");
        em.persist(client2);
        transac.commit();

        //Ajout d'un compte
        transac.begin();
        Compte compte = new Compte();
        compte.setId(1);
        compte.setLibelle("ComptePrincipal");
        em.persist(compte);
        transac.commit();

        //Ajout d'un deuxieme compte
        transac.begin();
        Compte compte2 = new Compte();
        compte2.setId(2);
        compte2.setLibelle("CompteSecondaire");
        em.persist(compte2);
        transac.commit();

        System.out.println("------------------------------");
        System.out.println("Formation des collections de comptes et de clients");

        // creation d'un collection de comptes
        Collection<Compte> listComptes = new ArrayList<>();
        listComptes.add(compte);
        listComptes.add(compte2);

        // creation d'une seconde collection de comptes
        Collection<Compte> listComptes2 = new ArrayList<>();
        listComptes2.add(compte);

        // creation d'un collection de clients
        Collection<Client> listClients = new ArrayList<>();
        listClients.add(client);
        listClients.add(client2);

        // creation d'une seconde collection de clients
        Collection<Client> listClients2 = new ArrayList<>();
        listClients2.add(client2);

        System.out.println("------------------------------");
        System.out.println("Attribution des clients aux comptes");

        // j'attribue des clients à mes comptes
        transac.begin();
        compte.setClients(listClients);
        compte2.setClients(listClients2);
        em.persist(compte);
        em.persist(compte2);
        transac.commit();

        // j'attribue les comptes aux clients
        transac.begin();
        client.setComptes(listComptes2);
        client2.setComptes(listComptes);
        em.persist(client);
        em.persist(client2);
        transac.commit();

        System.out.println("------------------------------");
        System.out.println("Attribution des comptes à l'agence");

        // j'attribue des comptes à l'agence
        transac.begin();
        agence.setComptes(listComptes);
        em.persist(agence);
        transac.commit();

        // attribution l'agence aux comptes
        transac.begin();
        compte.setAgence(agence);
        compte2.setAgence(agence);
        em.persist(compte);
        em.persist(compte2);
        transac.commit();

        System.out.println("------------------------------");
        System.out.println("Affichage des relations pour un client, un compte et une agence");

        // j'affiche les comptes liés au client2
        for (Compte compteAffiche : client2.getComptes()) {
            System.out.println("Libelle Comptes du client2: " + compteAffiche.getLibelle());
        }

        // j'affiche les clients liés au compte2
        for (Client clientAffiche : compte2.getClients()) {
            System.out.println("Nom Clients du compte2: " + clientAffiche.getNom());
        }

        // j'affiche l'agence liée au compte2
        System.out.println("Adresse Agence du compte2: " + compte2.getAgence().getAdresse());

        em.close();
        emf.close();
    }
}