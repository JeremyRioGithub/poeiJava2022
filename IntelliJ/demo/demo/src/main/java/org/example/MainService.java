package org.example;

import org.example.entities.Produit;
import org.example.services.ProduitService;

import java.util.Date;
import java.util.Scanner;

public class MainService {
    public static void main(String[] args) throws Exception {
        System.out.println("===============EX 1===============");

        // create product
        ProduitService ps = new ProduitService();
        ps.begin();
        ps.create( new Produit("TOSHIBA", "ref123456", new Date("2021/12/25"), 6000, 12));
        ps.create( new Produit("TOSH", "ref12684", new Date("2021/10/08"), 4000, 1));
        ps.create( new Produit("TOSHI", "ref11567", new Date("2021/09/20"), 5000, 5));
        ps.create( new Produit("TOTO", "ref145456", new Date("2021/07/21"), 1000, 24));
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

        System.out.println("===============EX 2===============");

        PileCorrection<String> produitPile = new PileCorrection<String>(String[].class, 1);
        PileCorrection<Produit> produitPile2 = new PileCorrection<Produit>(Produit[].class, 1);

        ps.begin();

        //ME:
        System.out.println("All products:");
        for(Produit produit : ps.getAllProducts()){
            System.out.println(produit.getId()+" , "+produit.getMarque()+" , "+produit.getReference()+" , "+produit.getDateAchat()+" , "+produit.getPrice());
        }
        System.out.println("All products with price>100:");
        for (Produit produit : ps.getProduitsSup(100)){
            System.out.println(produit.getId()+" , "+produit.getMarque()+" , "+produit.getReference()+" , "+produit.getDateAchat()+" , "+produit.getPrice());
        }
        // Get product between dates, first function is String
        ps.getProduitsEntreDates("2000/01/01", "2023/12/31");
        for (Produit prod : ps.getProduitsEntreDates("2000/01/01", "2023/12/31")){
            System.out.println(prod.getMarque());
        }
        // Get product between dates, second function is Date
        for (Produit prod : ps.filterByDate(new Date("2000/01/01"), new Date("2023/31/12"))){
            System.out.println(prod.getId() + " , " + prod.getMarque() + " , " + prod.getReference() + " , " + prod.getDateAchat() + " , " + prod.getPrice());
        }

        // FILTER BY MARK
        Scanner scanner = new Scanner(System.in);
        System.out.println("marque ?: ");
        String mark = scanner.nextLine();
        System.out.println("TOTAL of " + mark + " : " + ps.getTotalPriceByBrand(mark));

        // use Scanner to invoke Dates or marks.
        scanner = new Scanner(System.in);
        System.out.print("dateMin: ");
        String dateMin = scanner.nextLine();
        System.out.print("dateMax: ");
        String dateMax = scanner.nextLine();
        for (Produit prod : ps.filterByDate(new Date(dateMin), new Date(dateMax))){
            System.out.println(prod.getId() + " , " + prod.getMarque() + " , " + prod.getReference() + " , " + prod.getDateAchat() + " , " + prod.getPrice());
        }

        ps.envoie();
        ps.close();
    }
}
