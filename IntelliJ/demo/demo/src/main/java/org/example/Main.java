package org.example;

import org.example.model.Personne;
import org.example.model.PersonneWithPK;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Demojpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transac = em.getTransaction();


        //Ajouter une Personne
        transac.begin();
        Personne nouvellePersonne = new Personne();
        nouvellePersonne.setNom("toto");
        nouvellePersonne.setPrenom("tata");
        em.persist(nouvellePersonne);
        transac.commit();

        //Ajouter plusieurs Personnes
        transac.begin();
        Personne nouvellePersonneX = new Personne();
        for (int i=0;i<19;i++){
            nouvellePersonneX = new Personne();
            nouvellePersonneX.setNom("nom"+(i+2));
            nouvellePersonneX.setPrenom("prenom"+(i+2));
            em.persist(nouvellePersonneX);
        }
        transac.commit();

        //Ajouter une PersonneWithPK
        transac.begin();
        PersonneWithPK nouvellePersonneWithPK = new PersonneWithPK();
        nouvellePersonneWithPK.setNom("toto");
        nouvellePersonneWithPK.setPrenom("tata");
        //em.persist(nouvellePersonneWithPK);
        em.merge(nouvellePersonneWithPK);
        transac.commit();

        //Récupérer une Personne
        Personne personne = em.find(Personne.class, 1);
        System.out.println("Personne ID1 (find): "+ personne.getNom() +" "+ personne.getPrenom());
        Personne personne1 = em.getReference(Personne.class, 1);
        System.out.println("Personne ID1 (getReference): "+ personne1.getNom() +" "+ personne1.getPrenom());
        Query query = em.createQuery("select p from Personne p where p.nom='toto'");
        Personne personne2 = (Personne) query.getSingleResult();
        System.out.println("Personne ID1 (query): "+ personne2.getId() +" "+ personne2.getPrenom());

        // récupérer une personne parmi les doublons:
        Query query3 = em.createQuery("select p from Personne p where p.nom='nom10'");
        Personne personne3 = (Personne) query3.getSingleResult();
        System.out.println("Personne X (query): "+ personne3.getId() +" "+ personne3.getPrenom());

        System.out.println("----------------------");

        // récupérer une personne parmi les doublons:
        System.out.println("Liste de personnes avec id supérieur à 5:");
        Query query4 = em.createQuery("select p from Personne p where p.id > 5");
        List noms = query4.getResultList();
        for (Object nom: noms){
            Personne tmp =(Personne) nom;
            //System.out.println("Nom = " +tmp.getNom());
        };

        System.out.println("----------------------");

        //Utilisation du setParameter
        System.out.println("Liste de personnes avec id supérieur au paramètre set (id=15):");
        Query query5 = em.createQuery("select p from Personne p where p.id > :id");
        query5.setParameter("id", 15);
        List noms5 = query5.getResultList();
        for (Object nom: noms5){
            Personne tmp =(Personne) nom;
            System.out.println("Nom : " +tmp.getNom());
        };

        System.out.println("----------------------");

        //Modifier occurence
        transac.begin();
        System.out.println("Modifier occurence");
        Personne personne6 = em.find(Personne.class, 1);
        System.out.println("Personne ID1 (avant modif): " +personne6.getNom()+ " " +personne6.getPrenom());
        personne6.setNom("baguette");
        personne6.setPrenom("Le toto");
        em.flush();
        transac.commit();

        Personne personne7 = em.find(Personne.class, 1);
        System.out.println("Personne ID1 (après modif): " +personne7.getNom()+ " " +personne7.getPrenom());

        System.out.println("----------------------");

        // Suppression
        transac.begin();
        System.out.println("Suppress Personne ID6");
        Personne personne8 = em.find(Personne.class, 6);
        em.remove(personne8);
        transac.commit();

        Query query9 = em.createQuery("select p from Personne p where p.id between 5 and 7");
        List noms9 = query9.getResultList();
        for (Object nom: noms9){
            Personne tmp = (Personne) nom;
            System.out.println("query9: " +tmp.getPrenom()+ " " +tmp.getNom());
        }

        System.out.println("----------------------");

        //Native query
        System.out.println("Create native query:");
        List<Personne> results = em.createNativeQuery("select * from Personne", Personne.class).getResultList();
        for (Personne p: results){
            System.out.println("nom: "+ p.getNom());
        }




        em.close();
        emf.close();
    }
}