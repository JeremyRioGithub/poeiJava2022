class Animaux{
    String ferme="";
    String nom="";
    String mange="";
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

public class MangerManger {
    public static void main(String[] args){
        Animaux a1 = new Animaux("KFC", "poule", "graines");
        a1.aTable();
        Classe c1 = new Classe("Burkerking", "vache", "herbe", "mammifere");
        c1.aTable();
        // aTable() doit renvoyer poule:graines, vache:herbe, etc.
        // la vache est un mammifere, les animaux vivent dans une ferme
        // contrainte: reduire le code au maximum.
    }
}
