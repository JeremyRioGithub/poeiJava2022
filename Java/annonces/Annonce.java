package annonces;

import java.util.Scanner;

public class Annonce {
    protected String titre="No title";
    public String prix="";
    protected String descriptif="No description";
    public Annonce(){}
    public Annonce(String titre, String prix, String descriptif) {
        //this.titre=String.format("<< %s >>", titre);
        this.titre=titre;
        //this.prix="***"+Double.toString(Float.parseFloat(prix+".0") * 1.2) +" (incl. 20% TAX)***";
        this.prix=Double.toString(Float.parseFloat(prix+".0") * 1.2);
        //this.descriptif=String.format("[ %s ]", descriptif);
        this.descriptif=descriptif;
    }
    public String toString() {
        return String.format("%s %s", this.titre, this.prix);
    }
    public void afficher(){
        System.out.println(String.format("%s", this.descriptif));
    }
    public void saisie(Scanner sc1){
        System.out.println("titre : ");
        //this.titre=String.format("<< %s >>", sc1.nextLine());
        this.titre=sc1.nextLine();
        System.out.println("prix : ");
        //this.prix="***"+Double.toString(Float.parseFloat(sc1.nextLine()+".0") * 1.2) +" (incl. 20% TAX)***";
        //this.prix=sc1.nextLine();
        this.prix=Double.toString(Float.parseFloat(sc1.nextLine()+".0") * 1.2);
        System.out.println("description : ");
        //this.descriptif=String.format("[ %s ]", sc1.nextLine());
        this.descriptif=sc1.nextLine();
    }
    public void save(){
        String requete = String.format("INSERT INTO annonce (titre, prix, descriptif) VALUES (%s, %s, %s)", this.titre, this.prix, this.descriptif);
        System.out.println(requete);
    }
    public void load(int id){
        String requete = String.format("SELECT titre, prix, descriptif FROM annonce WHERE id=%d", id);
        System.out.println(requete);
    }
}
