package annonces;

import java.util.Scanner;

public class AnnonceMaison extends Annonce {
    private String surface="";
    public AnnonceMaison(){}
    public AnnonceMaison(String name, String surface, String price, String description) {
        super(name, price, description);
        this.surface=String.format("::: %s :::", surface);
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
        this.surface=String.format("::: %s :::", sc1.nextLine());
    }
}
