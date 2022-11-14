package annonces;

public class AnnonceMaison extends Annonce {
    String surface="";
    public AnnonceMaison(String name, String surface, Integer price, String description) {
        super(name, price, description);
        this.surface=String.format("::: %s :::", surface);
    }
    public String toString() {
        return String.format("%s (%d)", this.titre, this.prix);
    }
    public void afficher(){
        System.out.println(String.format("%s , %s", this.descriptif, this.surface));
    }
}
