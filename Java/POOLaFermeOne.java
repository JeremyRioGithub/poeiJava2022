import java.util.ArrayList;

class Animal{
    String nom;
    public Animal(){
        this.nom="inconnu";
    }
    public Animal(String nomAnimal){
        this.nom=nomAnimal;
    }
    public void manger(){
    }
}

class Bovin extends Animal{
    String description="grand, lourd, avec des cornes";
    public Bovin(String nom){
        super(nom);
    }
    public void manger(){
        System.out.println(String.format("Je m'appelle %s, je suis un bovin et je mange de l'herbe.", this.nom));
    }
}

class Ovipare extends Animal{
    String description="deux ailes et des plumes";
    public Ovipare(String nom){
        super(nom);
    }
    public void manger(){
        System.out.println(String.format("Je m'appelle %s, je suis un ovipare et je mange des graines.", this.nom));
    }
}

class Lapin extends Animal{
    String description="grandes dents/pattes/oreilles";
    public Lapin(String nom){
        super(nom);
    }
    public void manger(){
        System.out.println(String.format("Je m'appelle %s, je suis un lapin et je mange des carottes.", this.nom));
    }
}

class LaFerme{
    ArrayList<Animal> animals = new ArrayList<Animal>();
    public void ajouteAnimal(Animal a){
        animals.add(a);
    }
    public void aTable(){
        for (Animal animal : animals){
            animal.manger();
        }
    }
    public Animal appeler(String nom){
        for (Animal animal : animals){
            if (animal.nom.equals(nom)){
                return animal;
            }
        }
        return null;
    }
}

public class POOLaFermeOne {
    public static void main(String[] args){
        
        Bovin v1=new Bovin("Marguerite");
        Bovin v2=new Bovin("Noireaude");
        Bovin v3=new Bovin("Charal");
        Ovipare p1=new Ovipare("Gasby");
        Ovipare p2=new Ovipare("KFC");
        Ovipare p3=new Ovipare("Doux");
        Lapin l1=new Lapin("Jeannot");
        Lapin l2=new Lapin("Bugs");
        Lapin l3=new Lapin("Panpan");

        //Animal a1=new Animal(); // ajoute un animal qui est inconnu.

        //l1.manger();

        LaFerme f1 = new LaFerme();
        f1.ajouteAnimal(v1);
        f1.ajouteAnimal(v2);
        f1.ajouteAnimal(v3);

        f1.ajouteAnimal(p1);
        f1.ajouteAnimal(p2);
        f1.ajouteAnimal(p3);

        f1.ajouteAnimal(l1);
        f1.ajouteAnimal(l2);
        f1.ajouteAnimal(l3);

        //f1.ajouteAnimal(a1); // affiche un animal qui est inconnu, donc il ne mange rien, donc à l'appel il ne répond pas.

        f1.aTable(); // l'animal inconnu ne mange rien, donc à l'appel il ne répond pas.

        // aTable() doit renvoyer poule:graines, vache:herbe, etc.
        // la vache est un mammifere, les animaux vivent dans une ferme
        // contrainte: reduire le code au maximum.

        Animal animal=f1.appeler("Marguerite");
        animal.nom = "Margotte";
        f1.aTable();
        v1.nom = "MArgueeeeurite";
        f1.aTable();
    }
}
