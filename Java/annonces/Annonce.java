package annonces;

import java.util.Scanner;

public class Annonce {
    protected String titre="No title";
    public String prix="";
    protected String descriptif="No description";
    public Annonce(){}
    public Annonce(String titre, String prix, String descriptif) {
        this.titre=String.format("<< %s >>", titre);
        this.prix="***"+Double.toString(Float.parseFloat(prix+".0") * 1.2) +" (incl. 20% TAX)***";
        this.descriptif=String.format("[ %s ]", descriptif);
    }
    public String toString() {
        return String.format("%s %s", this.titre, this.prix);
    }
    public void afficher(){
        System.out.println(String.format("%s", this.descriptif));
    }
    public void saisie(Scanner sc1){
        System.out.println("titre : ");
        this.titre=String.format("<< %s >>", sc1.nextLine());
        System.out.println("prix : ");
        this.prix="***"+Double.toString(Float.parseFloat(sc1.nextLine()+".0") * 1.2) +" (incl. 20% TAX)***";
        System.out.println("description : ");
        this.descriptif=String.format("[ %s ]", sc1.nextLine());
    }
}
