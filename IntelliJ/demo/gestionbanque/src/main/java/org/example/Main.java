package org.example;

import com.sun.xml.fastinfoset.tools.XML_SAX_StAX_FI;
import org.example.entity.Agence;
import org.example.entity.Client;
import org.example.entity.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static Agence addAgency(Integer id, EntityManager em){
        Agence agence = new Agence();
        agence.setId(id);
        agence.setAdresse(id+" rue de la paix");
        em.persist(agence);
        return agence;
    }
    public static Client addClient(Integer id, EntityManager em){
        Client client = new Client();
        client.setId(id);
        client.setNom("NomClient"+id);
        em.persist(client);
        return client;
    }
    public static Compte addAccount(Integer id, EntityManager em){
        Compte compte = new Compte();
        compte.setId(id);
        compte.setLibelle("ComptePrincipal"+id);
        em.persist(compte);
        return compte;
    }
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercice");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        System.out.println("------------------------------");
        System.out.println("Ajout d'agence, clients et comptes");

        // OUVERTURE TRANSACTION
        transac.begin();

        //Ajout d'une agence
        Agence agence = addAgency(1,em);
        //Ajout d'un client
        Client client = addClient(1,em);
        //Ajout d'un deuxieme client
        Client client2 = addClient(2,em);
        //Ajout d'un compte
        Compte compte = addAccount(1,em);
        //Ajout d'un deuxieme compte
        Compte compte2 = addAccount(2,em);

        // FERMETURE TRANSACTION
        transac.commit();

        System.out.println("------------------------------");
        System.out.println("Formation des collections de comptes et de clients");

        // creation d'un premiere collection de COMPTES
        Collection<Compte> listComptes = new ArrayList<>();
        listComptes.add(compte);
        listComptes.add(compte2);

        // creation d'une seconde collection de COMPTES
        Collection<Compte> listComptes2 = new ArrayList<>();
        listComptes2.add(compte);

        // creation d'un premiere collection de CLIENTS
        Collection<Client> listClients = new ArrayList<>();
        listClients.add(client);
        listClients.add(client2);

        // creation d'une seconde collection de CLIENTS
        Collection<Client> listClients2 = new ArrayList<>();
        listClients2.add(client2);

        System.out.println("------------------------------");
        System.out.println("Attribution des clients aux comptes");
        transac.begin();

        // j'attribue des clients à mes comptes
        compte.setClients(listClients);
        compte2.setClients(listClients2);
        // j'attribue les comptes aux clients
        client.setComptes(listComptes2);
        client2.setComptes(listComptes);

        //persistence
        em.persist(compte);
        em.persist(compte2);
        em.persist(client);
        em.persist(client2);

        transac.commit();
        System.out.println("------------------------------");
        System.out.println("Attribution des comptes à l'agence");
        transac.begin();

        // j'attribue des comptes à l'agence
        agence.setComptes(listComptes);
        em.persist(agence);

        // attribution l'agence aux comptes
        compte.setAgence(agence);
        compte2.setAgence(agence);
        em.persist(compte);
        em.persist(compte2);

        transac.commit();
        System.out.println("------------------------------");
        System.out.println("Exemples d'affichage des relations pour un client, un compte et une agence");

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

        System.out.println("------------------------------");
        System.out.println("Creation nouveau client, lecture clavier...");

        // demande à l'utilisateur d'ajouter un client, et lui demander un nom:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add New Client ? (y/n): ");
        String newClient = scanner.nextLine();
        System.out.println("You wrote : " + newClient);
        Integer maxId = null;
        Client chosenClient;
        // creation d'un nouvelle collection de COMPTES vide
        Collection<Compte> newListComptes = new ArrayList<>();
        // creation d'un nouvelle collection de CLIENTS vide
        Collection<Client> newListClients = new ArrayList<>();

        if (newClient.matches("y|yes|Y|YES|ye|YE")) {
            System.out.println("Adding new client...");

            //retrieve last max id in clients
            maxId = 0;
            for (Client clientAffiche : listClients) {
                maxId = clientAffiche.getId();
            }
            System.out.println("Max ID: " + maxId);
            maxId += 1;
            System.out.println("Will create Client with ID: " + maxId);

            // adds the client
            transac.begin();
            chosenClient = addClient(maxId,em);
            transac.commit();
            //adds client to the collection of clients
            newListClients.add(chosenClient);

            //Ajout d'un compte par defaut
            transac.begin();
            Compte compte3 = addAccount(maxId,em);
            transac.commit();
            //ajout du compte par defaut à la collection de comptes
            newListComptes.add(compte3);

            System.out.println("... DONE");

        } else {
            System.out.println("Leaving Process... DONE");
        }

        System.out.println("------------------------------");
        System.out.println("Liaison à un compte existant, lecture clavier...");

        // recuperation du client de l'utilisateur
        chosenClient = em.find(Client.class, maxId);

        // demande à l'utilisateur de se lier à un compte existant:
        scanner = new Scanner(System.in);
        System.out.println("Chose account to be linked to: ");
        for (Compte compteAffiche : newListComptes) {
            System.out.print(compteAffiche.getId() + ", ");
        }
        Integer chosenCompte = scanner.nextInt();
        //retrieve the told chosenAccount:
        Compte chosenAccount = em.find(Compte.class, chosenCompte);
        System.out.println("Chosen account ID: " + chosenAccount.getId());

        // creation d'une collection de clients pour le nouveau client
        Collection<Client> listChosenClient = new ArrayList<>();
        listChosenClient.add(chosenClient);

        // creation d'une collection de comptes, et ajout du compte selectionné
        Collection<Compte> listChosenCompte = new ArrayList<>();
        listChosenCompte.add(chosenAccount);

        // j'attribue le compte selectionné au nouveau client
        transac.begin();
        chosenClient.setComptes(listChosenCompte);
        em.persist(chosenClient);
        transac.commit();

        // j'attribue le client à sa liste de comptes (ne contient qu'un compte)
        transac.begin();
        chosenAccount.setClients(listChosenClient);
        em.persist(chosenAccount);
        transac.commit();

        System.out.println("... DONE");

        em.close();
        emf.close();
    }
}