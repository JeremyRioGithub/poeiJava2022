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
        AnnonceVoiture voiture= new AnnonceVoiture("fiote500", "3500", "en l'état", "essence");
        System.out.print(voiture + "\t");
        voiture.afficher();

        // Sans la saisie :
        System.out.print("annonce type Maison : \t");
        AnnonceMaison maison= new AnnonceMaison("chaumiere", "55000", "a renover", "100m2");
        System.out.print(maison + "\t");
        maison.afficher();

        System.out.println("nouvelle Annonce: \t");
        Annonce a=new Annonce();
        Annonce b=new Annonce();
        String annonce=sc1.nextLine();
        if (annonce.equals("voiture")){
            a=new AnnonceVoiture();
            b=new AnnonceVoiture();
        }
        else if (annonce.equals("maison")){
            a=new AnnonceMaison();
            b=new AnnonceMaison();
        }
        a.saisie(sc1);
        System.out.print(a + "\t");
        a.afficher();
        a.save();

        b.load(2);
        System.out.println(b);

        sc1.close();
    }
}