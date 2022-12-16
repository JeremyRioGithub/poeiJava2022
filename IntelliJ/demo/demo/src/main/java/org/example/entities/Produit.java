package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Produit {
    @Id
    @GeneratedValue
    private int id;
    private String marque;
    private String reference;
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    private double price;
    private int stock;

    public Produit() {
    }

    public Produit(String marque, String reference, Date dateAchat, double price, int stock) {
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
