import java.util.Scanner;

import annonces.*;

class LeBonCoin {
    static Scanner sc1 = new Scanner(System.in);
    public static void main(String[] args) {
        // Sans la saisie :
        System.out.print("annonce de Base : \t");
        Annonce base1= new Annonce("pasCher", "55", "chaussetteUsagees");
        System.out.print(base1 + "\t");
        base1.afficher();

        // Sans la saisie :
        System.out.print("annonce type Voiture : \t");
        AnnonceVoiture voiture= new AnnonceVoiture("fiote500", "essence", "3500", "en l'état");
        System.out.print(voiture + "\t");
        voiture.afficher();

        // Sans la saisie :
        System.out.print("annonce type Maison : \t");
        AnnonceMaison maison= new AnnonceMaison("chaumiere", "100m2", "55000", "a renover");
        System.out.print(maison + "\t");
        maison.afficher();

        /*
        // Utilisation du calcul sur le prix de voiture en tant qu'entier:
        String totalPrice="";
        Integer calculs=Integer.parseInt(voiture.prix) * 2;
        totalPrice = Integer.toString(calculs);
        System.out.println(String.format("(voiture.prix)*2=%s", totalPrice));

        // Utilisation du calcul sur le prix de voiture en tant que Double :
        String totalPrice2="";
        Double calculs2=(Float.parseFloat(voiture.prix+".0") * 2.1);
        totalPrice2 = Double.toString(calculs2);
        System.out.println(String.format("(voiture.prix)*2=%s", totalPrice2));
        */
        
        System.out.println("nouvelle Annonce: \t");
        Annonce a=new Annonce();
        String annonce=sc1.nextLine();
        if (annonce.equals("voiture")){
            a=new AnnonceVoiture();
        }
        else if (annonce.equals("maison")){
            a=new AnnonceMaison();
        }
        a.saisie(sc1);
        System.out.print(a + "\t");
        a.afficher();

        sc1.close();
    }
}