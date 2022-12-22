package com.example.demo.service;

import com.example.demo.entity.Produit;
import com.example.demo.interfaces.IDAO;
import com.example.demo.tools.ServiceHibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService implements IDAO<Produit> {

    // @Autowired
    private ServiceHibernate serviceHibernate;

    private Session session;

    public ProduitService(ServiceHibernate serviceHibernate){
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }

    @Override
    public boolean create(Produit o) {
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;

    }

    @Override
    public boolean delete(Produit o) {
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        //produit = session.find(Produit.class, id); // fonctionne
        produit = (Produit) session.get(Produit.class, id);
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = session.createQuery("from Produit").list();
        return produits;
    }
}