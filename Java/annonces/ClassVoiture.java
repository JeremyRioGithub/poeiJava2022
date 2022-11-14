package annonces;

public class ClassVoiture extends ClassBase {
    String fuel="";
    public ClassVoiture(String name, String fuel) {
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
