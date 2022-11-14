import annonces.*;
class LeBonCoin {
    public static void main(String[] args) {
        System.out.print("annonce de Base ? : ");
        Annonce base= new Annonce("base-1");
        System.out.println(base);
        base.afficher();

        System.out.print("annonce type Voiture ? : ");
        AnnonceVoiture voiture= new AnnonceVoiture("voiture-1", "essence");
        System.out.println(voiture);
        voiture.afficher();

        System.out.print("annonce type Maison ? : ");
        AnnonceMaison maison= new AnnonceMaison("maison-1", "100m2");
        System.out.println(maison);
        maison.afficher();
    }
}