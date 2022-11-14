import annonces.*;
class LeBonCoin {
    public static void main(String[] args) {
        System.out.print("annonce de Base : \t");
        Annonce base= new Annonce("pasCher", 55, "chaussetteUsagees");
        System.out.print(base + "\t");
        base.afficher();

        System.out.print("annonce type Voiture : \t");
        AnnonceVoiture voiture= new AnnonceVoiture("fiote500", "essence", 3500, "en l'état");
        System.out.print(voiture + "\t");
        voiture.afficher();

        System.out.print("annonce type Maison : \t");
        AnnonceMaison maison= new AnnonceMaison("chaumiere", "100m2", 55000, "a renover");
        System.out.print(maison + "\t");
        maison.afficher();
    }
}