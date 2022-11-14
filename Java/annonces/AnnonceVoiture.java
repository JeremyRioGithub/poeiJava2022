package annonces;

public class AnnonceVoiture extends Annonce {
    String fuel="";
    public AnnonceVoiture(String name, String fuel) {
        super(name);
        this.fuel=fuel;
    }
    public String toString() {
        return "'je suis une annonce de type voiture'";
    }
    public void afficher(){
        System.out.println(String.format("annonce Voiture : '%s' (%s)", name, fuel));
    }
}
