package org.example.interfaces;

import org.example.entities.Produit;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface IDAO<Type> {
    void begin();
    boolean create(Type object);

    boolean update(Type object);

    boolean delete(Type object);

    Type findById(int id);
    void envoie();
    void close();

    List<Type> getAllProducts();

    List<Type> getProduitsSup(int price);

    List<Produit> getProduitsEntreDates(String dateAvant, String dateApres);
}