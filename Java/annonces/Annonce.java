package annonces;

public class Annonce {
    String titre="No title";
    Integer prix=-1;
    String descriptif="No description";
    public Annonce(String titre, Integer prix, String descriptif) {
        this.titre=String.format("<< %s >>", titre);
        this.prix=prix;
        this.descriptif=String.format("[ %s ]", descriptif);;
    }
    public String toString() {
        return String.format("%s (%d)", this.titre, this.prix);
    }
    public void afficher(){
        System.out.println(String.format("%s", this.descriptif));
    }
}
