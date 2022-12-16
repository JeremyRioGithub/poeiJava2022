package org.example;

import org.example.entities.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Date;

public class test {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Demojpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        //Ajouter 5 Produits
        transac.begin();
        for (int i=0; i<5; i++){
            Produit produit = new Produit();
            produit.setMarque("produit"+ (i+1));
            produit.setPrice((i+0.99));
            produit.setReference("ref"+(i+1));
            produit.setDateAchat(new Date());
            produit.setStock((i*10)+(i*8)+(3));
            em.persist(produit);
        }
        transac.commit();

        System.out.println("----------------------");

        //afficher information ID2 (native query)
        Produit produitId2 = em.find(Produit.class, 2);
        System.out.println("Get Produit ID2: \n\t"+
                "\n\tREF: \t" +produitId2.getReference()+
                "\n\tMARQUE: \t" +produitId2.getMarque() +
                "\n\tDATE: \t" +produitId2.getDateAchat() +
                "\n\tPRICE: \t" +produitId2.getPrice() +
                "\n\tSTOCK: \t" +produitId2.getStock()
        );

        System.out.println("----------------------");

        // Supprimer produit id3
        transac.begin();
        System.out.println("Suppress Produit ID3...");
        Produit produitId3 = em.find(Produit.class, 3);
        em.remove(produitId3);
        transac.commit();

        System.out.println("----------------------");

        transac.begin();
        System.out.println("Modify Produit ID1");
        Produit produitId1 = em.find(Produit.class, 1);
        System.out.println("Produit ID1 Mark (before): " +produitId1.getMarque());
        produitId1.setMarque("Nutella");
        produitId1.setPrice(3.50);
        em.flush();
        transac.commit();
        Produit produitId1after = em.find(Produit.class, 1);
        System.out.println("Produit ID1 Mark (after): " +produitId1after.getMarque());

    }
}
