package org.example.services;

import org.example.entities.Produit;
import org.example.interfaces.IDAO;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

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


    @Override
    public List<Produit> getAllProducts(){
        Query query = em.createQuery("select p from Produit p");
        List<Produit> list = query.getResultList();
        return list;
    }
    @Override
    public List<Produit> getProduitsSup(int price){
        Query query = em.createQuery("select p from Produit p where p.price > "+price);
        List<Produit> list = query.getResultList();
        return list;
    }

    @Override
    public List<Produit> getProduitsEntreDates(String dateAvant, String dateApres){
        System.out.println(dateAvant+ "," +dateApres );
        Query query = em.createQuery("select p from Produit p where p.dateAchat between '"+dateAvant+"' and '"+dateApres+"'");
        System.out.println(query.getResultList());
        List<Produit> list = query.getResultList();
        if (list.size() != 0){
            return list;
        }
        else {
            return null;
        }
    }

    public List<Produit> filterByDate(Date min, Date max) throws Exception {
        System.out.println("TESTED DATES: "+min.toString() + ", " + max.toString());
        if(min.before(max)){
            Query query= em.createQuery("select p from Produit p where dateAchat >= :min and dateAchat <= :max");
            query.setParameter("min",min);
            query.setParameter("max",max);
            return query.getResultList();
        }
        throw new Exception("error date");
    }

    public double getTotalPriceByBrand(String brand) {
        Query query = em.createQuery("SELECT SUM(price) FROM Produit p WHERE marque =:brandS");
        query.setParameter("brandS", brand);
        return (double) query.getSingleResult();
    }
}
