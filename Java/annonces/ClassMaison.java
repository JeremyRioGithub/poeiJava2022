package annonces;

public class ClassMaison extends ClassBase {
    String surface="";
    public ClassMaison(String name, String surface) {
        super(name);
        this.surface=surface;
    }
    public String toString() {
        return "'je suis une annonce de type maison'";
    }
    public void afficher(){
        System.out.println(String.format("annonce Maison : '%s' (%s)", name, surface));
    }
}
