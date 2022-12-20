package org.example;

import org.example.entity.Agence;
import org.example.entity.Client;
import org.example.entity.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class Menu {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercice");
    private static final EntityManager em = emf.createEntityManager();
    public static void aff_menu(){
        System.out.println("1- Create all");
        System.out.println("2- Create account");
        System.out.println("3- Add client to account");
        System.out.println("4- Exit");
    }
    public static void exo() {
        System.out.println("############## Menu #############");
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        do {
            try {
                afficheAll();
                aff_menu();
                choix = sc.nextInt();
                switch (choix) {
                    case 1 -> creation();
                    case 2 -> System.out.println("Case 2");
                    case 3 -> System.out.println("Case 3");
                    case 4 -> System.out.println("Bye !");
                    default -> System.out.println("Invalid choice");
                }
            } catch (InputMismatchException ex) {
                    System.out.println("Give an integer");
                    //aff_menu();
            }
        }while (choix != 4);
    }
    public static void afficheAll(){
        System.out.println("################# Account Informations ###################");
        Query queryAgence = em.createQuery("select a from Agence a");
        List<Agence> agences = queryAgence.getResultList();
        for (Agence agence : agences){
            System.out.println("###########");
            System.out.printf("Agence id: %d a l'adresse %s", agence.getId(), agence.getAdresse());
            System.out.println("Agence getCompte:" + agence.getComptes());
            for (Compte compte : agence.getComptes()){
                System.out.printf("\tCompte avec id: %d, libelle: %s, solde: %f", compte.getId(), compte.getLibelle(), compte.getSolde());
                System.out.println("\t\tOwner(s):");
                for (Client client : compte.getClients()){
                    System.out.printf("Client avec id: %d, Nom: %s, Prenom: %s", client.getId(), client.getNom(), client.getPrenom());
                }
            }
        }
    }
    public static void creation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("The agency ADRESS ?");
        String adress = sc.nextLine();
        Agence agence = new Agence();
        agence.setAdresse(adress);
        em.persist(agence);

        Client client = new Client();
        System.out.println("Your LAST NAME ?");
        String nom = sc.nextLine();
        System.out.println("Your FIRST NAME ?");
        String prenom = sc.nextLine();
        /*System.out.println("Your BIRTH DATE ? (yyyy-mm-dd)");
        String date_s = sc.nextLine();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(date_s);
        } catch (ParseException e){
            throw new RuntimeException();
        }*/
        client.setNom(nom);
        client.setPrenom(prenom);
        //client.setNaissance(date);
        em.persist(client);

        System.out.println("Your account LABEL ?");
        String label = sc.nextLine();
        System.out.println("Your IBAN ?");
        String iban = sc.nextLine();
        System.out.println("Account money ?");
        double solde = sc.nextDouble();
        Compte compte = new Compte();
        compte.setLibelle(label);
        compte.setIban(iban);
        compte.setSolde(solde);
        compte.setAgence(agence);

        Collection<Compte> comptes = new ArrayList<>();
        comptes.add(compte);

        Collection<Client> clients = compte.getClients();
        clients.add(client);

        compte.setClients(clients);
        client.setComptes(comptes);

        compte.getClients().add(client);
        client.getComptes().add(compte);
        //agence.setComptes(comptes);
        em.persist(compte);
        em.persist(client);
        //em.persist(agence);

    }
}
