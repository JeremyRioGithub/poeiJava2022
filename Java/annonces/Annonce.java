package annonces;

public class Annonce {
    String name="";
    public Annonce(String name) {
        this.name=name;
    }
    public String toString() {
        return "'je suis une annonce de base'";
    }
    public void afficher(){
        System.out.println(String.format("annonce Base : '%s'", name));
    }
}
