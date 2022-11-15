package annonces;
import java.util.Scanner;

public class Annonce {
    protected String titre="No title";
    public String prix="";
    protected String descriptif="No description";
    public Annonce(){}
    public Annonce(String titre, String prix, String descriptif) {
        this.titre=titre;
        this.prix=Double.toString(Float.parseFloat(prix+".0") * 1.2);
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
        this.titre=sc1.nextLine();
        System.out.println("prix : ");
        this.prix=Double.toString(Float.parseFloat(sc1.nextLine()+".0") * 1.2);
        System.out.println("description : ");
        this.descriptif=sc1.nextLine();
    }
    public String save(){
        String requete = String.format("INSERT INTO annonce (type, titre, prix, description) VALUES ('%s', '%s', '%s', '%s');", "BASE", this.titre, this.prix, this.descriptif);
        return requete;
        //AppelSQL sq = new AppelSQL();
    }
    public String load(int id){
        String requete = String.format("SELECT * FROM annonce WHERE id=%d;", id);
        return requete;
    }
    public String load(){
        String requete = String.format("SELECT * FROM annonce;");
        return requete;
    }
}
