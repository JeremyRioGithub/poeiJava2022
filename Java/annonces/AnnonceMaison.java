package annonces;

import java.util.Scanner;

public class AnnonceMaison extends Annonce {
    private String surface="";
    public AnnonceMaison(){}
    public AnnonceMaison(String titre, String prix, String description, String surface) {
        super(titre, prix, description);
        this.surface=surface;
    }
    public String toString() {
        return String.format("%s (%s)", this.titre, this.prix);
    }
    public void afficher(){
        System.out.println(String.format("%s , %s", this.descriptif, this.surface));
    }
    public void saisie(Scanner sc1){
        super.saisie(sc1);
        System.out.println("surface : ");
        this.surface=sc1.nextLine();
    }
    public String save(){
        String requete = String.format("INSERT INTO annonce (titre, prix, description) VALUES ('%s', '%s', '%s');", this.titre, this.prix, this.descriptif);
        return requete;
    }
    public String load(int id){
        String requete = String.format("SELECT * FROM annonce WHERE id=%d;", id);
        return requete;
    }
}
