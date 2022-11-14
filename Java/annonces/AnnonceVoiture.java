package annonces;

public class AnnonceVoiture extends Annonce {
    String fuel="";
    public AnnonceVoiture(String name, String fuel, Integer price, String description) {
        super(name, price, description);
        this.fuel=String.format(":::%s:::", fuel);
    }
    public String toString() {
        return String.format("%s (%d)", this.titre, this.prix);
    }
    public void afficher(){
        System.out.println(String.format("%s , %s", this.descriptif, this.fuel));
    }
}
