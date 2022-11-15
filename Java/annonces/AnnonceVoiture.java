package annonces;

import java.util.Scanner;

public class AnnonceVoiture extends Annonce {
    String fuel="";
    public AnnonceVoiture(){}
    public AnnonceVoiture(String titre, String prix, String description, String fuel) {
        super(titre, prix, description);
        this.fuel=fuel;
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
        this.fuel=sc1.nextLine();
    }
    public String save(){
        String requete = String.format("INSERT INTO annonce (type, titre, prix, description, essence) VALUES ('%s', '%s', '%s', '%s', '%s');", "VOIT", this.titre, this.prix, this.descriptif, this.fuel);
        return requete;
    }
}
