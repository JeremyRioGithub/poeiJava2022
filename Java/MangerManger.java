import java.util.ArrayList;

import javax.swing.plaf.synth.SynthScrollPaneUI;

class Animaux{
    String nom="";
    String mange="";
    String ferme="";
    public Animaux(String ferme, String nom, String mange){
        this.ferme=ferme;
        this.nom=nom;
        this.mange=mange;
    }
    public void aTable(){
        System.out.println(String.format("%s mange %s a la ferme %s", this.nom, this.mange, this.ferme));
    }
}
class Classe extends Animaux{
    String classif="";
    public Classe(String ferme, String nom, String mange, String classif){
        super(ferme, nom, mange);
        this.classif=classif;
    }
    public void aTable(){
        System.out.println(String.format("%s qui est %s mange %s a la ferme %s", this.nom, this.classif, this.mange, this.ferme));
    }

}

class Ferme{
    String nom="";
    ArrayList<Animaux> animals = new ArrayList<Animaux>();
    ArrayList<Classe> classes = new ArrayList<Classe>();
    public Ferme(String nom){
        this.nom=nom;
    }
    public String getFermeName(){
        return this.nom;
    }
    public void addAnimal(Animaux animal){
        animals.add(animal);
    }
    public void addClasse(Classe classe){
        classes.add(classe);
    }
    public void afficher(){
        for (Animaux animal : animals){
            animal.aTable();
        }
        for (Classe classe : classes){
            classe.aTable();
        }
    }
}

public class MangerManger {
    public static void main(String[] args){
        Ferme f1= new Ferme("KFCfarm");
        f1.addAnimal(new Animaux("KFC","poule", "graines"));
        f1.addAnimal(new Classe("Burgerking","vache", "herbe", "mammifere"));
        f1.afficher();
        // aTable() doit renvoyer poule:graines, vache:herbe, etc.
        // la vache est un mammifere, les animaux vivent dans une ferme
        // contrainte: reduire le code au maximum.
    }
}
