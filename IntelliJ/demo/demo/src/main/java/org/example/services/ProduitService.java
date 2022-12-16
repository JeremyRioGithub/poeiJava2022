package org.example.services;

import org.example.entities.Produit;
import org.example.interfaces.IDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProduitService implements IDAO<Produit> {

    private EntityManagerFactory emf;
    private EntityManager em;
    public ProduitService(){
        emf = Persistence.createEntityManagerFactory("Demojpa");
        em = emf.createEntityManager();
    }

    @Override
    public void begin() {
        em.getTransaction().begin();
        System.out.println("Start persistence");
    }

    @Override
    public boolean create(Produit object) {
        em.persist(object);
        System.out.println("Create " +object);
        return true;
    }

    @Override
    public boolean update(Produit object) {
        em.persist(object);
        System.out.println("Update " +object);
        return true;
    }

    @Override
    public boolean delete(Produit object) {
        em.remove(object);
        System.out.println("Delete " +object);
        return true;
    }

    @Override
    public Produit findById(int id) {
        System.out.println("Find with ID " +id);
        return em.find(Produit.class, id);
    }

    @Override
    public void envoie() {
        System.out.println("Commit");
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        System.out.println("Close persistence");
        em.close();
    }
}
