package annonces;

import java.util.Scanner;

public class AnnonceVoiture extends Annonce {
    String fuel="";
    public AnnonceVoiture(){}
    public AnnonceVoiture(String name, String fuel, String price, String description) {
        super(name, price, description);
        this.fuel=String.format(":::%s:::", fuel);
    }
    public String toString() {
        return String.format("%s (%s)", this.titre, this.prix);
    }
    public void afficher(){
        System.out.println(String.format("%s , %s", this.descriptif, this.fuel));
    }
    public void saisie(Scanner sc1){
        super.saisie(sc1);
        System.out.println("fuel : ");
        this.fuel=String.format("::: %s :::", sc1.nextLine());
    }
}
