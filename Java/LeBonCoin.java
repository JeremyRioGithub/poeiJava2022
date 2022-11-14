import annonces.*;
class LeBonCoin {
    public static void main(String[] args) {
        System.out.print("annonce de Base ? : ");
        ClassBase base= new ClassBase("base-1");
        System.out.println(base);
        base.afficher();

        System.out.print("annonce type Voiture ? : ");
        ClassVoiture voiture= new ClassVoiture("voiture-1", "essence");
        System.out.println(voiture);
        voiture.afficher();

        System.out.print("annonce type Maison ? : ");
        ClassMaison maison= new ClassMaison("maison-1", "100m2");
        System.out.println(maison);
        maison.afficher();
    }
}