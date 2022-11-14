import java.util.Scanner;

import annonces.*;
class LeBonCoin {
    static Scanner sc1 = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("annonce de Base : \t");
        Annonce base1= new Annonce("pasCher", "55", "chaussetteUsagees");
        System.out.print(base1 + "\t");
        base1.afficher();

        System.out.print("annonce type Voiture : \t");
        AnnonceVoiture voiture= new AnnonceVoiture("fiote500", "essence", "3500", "en l'état");
        System.out.print(voiture + "\t");
        voiture.afficher();

        System.out.print("annonce type Maison : \t");
        AnnonceMaison maison= new AnnonceMaison("chaumiere", "100m2", "55000", "a renover");
        System.out.print(maison + "\t");
        maison.afficher();

        System.out.println("nouvelle Annonce Base: \t");
        Annonce annonce1 = new Annonce();
        annonce1.saisie(sc1);
        System.out.println("nouvelle Annonce Voiture: \t");
        AnnonceVoiture voiture1 = new AnnonceVoiture();
        voiture1.saisie(sc1);

        
        System.out.print(annonce1 + "\t");
        annonce1.afficher();
        System.out.print(voiture1 + "\t");
        voiture1.afficher();
        
        sc1.close();
    }
}