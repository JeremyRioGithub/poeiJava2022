import java.util.ArrayList;

class Animaux{
    String nom="inconnu";
    String mange="eau";
    String ferme="maison";
    String ordre="animal";
    public Animaux(String mange){
        this.mange=mange;
    }
    public Animaux(String ferme, String nom, String mange){
        this.ferme=ferme;
        this.nom=nom;
        this.mange=mange;
    }
    public Animaux(String ferme, String nom, String mange, String ordre){
        this.ferme=ferme;
        this.nom=nom;
        this.mange=mange;
        this.ordre=ordre;
    }
    public void aTable(){
        System.out.println(String.format("le %s %s se nourrit de %s à la %s", this.ordre, this.nom, this.mange, this.ferme));
    }
}

class Ferme{
    String nom="";
    ArrayList<Animaux> animals = new ArrayList<Animaux>();
    public Ferme(String nom){
        this.nom=nom;
    }
    public String getFermeName(){
        return this.nom;
    }
    public void addAnimal(Animaux animal){
        animals.add(animal);
    }
    public void afficher(){
        for (Animaux animal : animals){
            animal.aTable();
        }
    }
}

public class MangerManger {
    public static void main(String[] args){
        Ferme f1= new Ferme("KFCfarm");
        f1.addAnimal(new Animaux("KFC","poule", "graines"));
        f1.addAnimal(new Animaux("Burgerking","vache", "herbe", "mammifere"));
        f1.addAnimal(new Animaux("cable electrique"));
        f1.afficher();
        // aTable() doit renvoyer poule:graines, vache:herbe, etc.
        // la vache est un mammifere, les animaux vivent dans une ferme
        // contrainte: reduire le code au maximum.
    }
}
