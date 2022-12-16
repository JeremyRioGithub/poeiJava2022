package org.example;

import org.example.entities.Produit;
import org.example.services.ProduitService;

import java.util.Date;

public class MainService {
    public static void main(String[] args) {
        System.out.println("===============EX 1===============");

        // create product
        ProduitService ps = new ProduitService();
        ps.begin();
        ps.create( new Produit("TOSHIBA", "ref123456", new Date("2021/12/25"), 6000, 12));
        ps.create( new Produit("TOSH", "ref12684", new Date("2021/10/08"), 4000, 1));
        ps.create( new Produit("TOSHI", "ref11567", new Date("2021/09/20"), 5000, 5));
        ps.create( new Produit("TOSHIV", "ref145456", new Date("2021/07/21"), 1000, 24));
        ps.create( new Produit("TOTO", "ref00012", new Date("2020/06/10"), 100, 82));
        ps.envoie();

        // get info id2
        ps.begin();
        Produit p = ps.findById(2);
        System.out.println("ID2: " + p.getId());
        ps.envoie();

        //delete id3
        ps.begin();
        ps.delete(ps.findById(3));
        ps.envoie();

        //update id1
        ps.begin();
        p = ps.findById(1);
        if (p != null) {
            p.setMarque("POJO");
            p.setPrice(13200);
            p.setReference("ref000xxx");
            p.setStock(1);
            p.setDateAchat(new Date("2022/12/16"));
            ps.update(p);
        }
        ps.envoie();

        ps.close();
    }
}
