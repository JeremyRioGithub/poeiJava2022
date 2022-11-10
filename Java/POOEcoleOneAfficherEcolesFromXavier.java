import java.util.ArrayList;

class Note
{
    String matiere;
    Integer note;

    public Note( String mat, Integer n)
    {
        this.matiere = mat;
        this.note = n;
    }

    @Override
    public String toString() {
        return "(" + matiere + ", " + note + ")";
    } 
}

class CarnetNotes
{
    ArrayList<Note> notes = new ArrayList<>(); 

    public CarnetNotes(){}

    public void ajouter( Note n )
    {
        this.notes.add( n );
    }

    public String toString()
    {
        String res = "";
        for (Note n : this.notes) {
            res += n;
            res += "<>";
        }
        return "[" + res + "]";
    }
}

class Klasse
{
    String nom;
    String niveau;

    ArrayList<Eleve> eleves = new ArrayList<>();
    Prof instituteur;

    public Klasse( String nom, String niv, Prof inst )
    {
        this.nom = nom;
        this.niveau = niv;
        this.instituteur = inst;
    } 

    public void ajouterEleve( Eleve e )
    {
        this.eleves.add( e );
    }

    public void affiche()
    {
        System.out.println( String.format("Classe        : %s", this.nom)  );
        System.out.println( String.format("Niveau        : %s", this.niveau)  );
        System.out.println( String.format("Instituteur   : %s", this.instituteur)  );
        for (Eleve eleve : this.eleves ) {
            System.out.println( String.format("    - %s", eleve)  );
        }
        System.out.println();
    }
}

class Ecole {
    
    private ArrayList<Individus> individus = new ArrayList<>();
    private ArrayList<Klasse> klasses = new ArrayList<>();

    public void ajouterPersonne(Individus a) {
        this.individus.add(a);
    }

    public void ajouterKlasse(Klasse k) {
        this.klasses.add(k);
    }

    // 
    public Individus chercherIndividus (String nomATrouver) {
        for (Individus personne : this.individus) {
            if (personne.nom.equals(nomATrouver))
                return personne;
        }
        return null;
    }

    public Klasse chercherKlasse(String nomATrouver) {
        for (Klasse klasse : this.klasses) {
            if (klasse.nom.equals(nomATrouver))
                return klasse;
        }
        return null;
    }

    public ArrayList<Eleve> listerEleve() {
        ArrayList<Eleve> listRetour = new ArrayList<>();

        for (Individus personne : this.individus) {
            if (personne.getClass().getSimpleName().equals("Eleve")) {
                listRetour.add((Eleve) personne);
            }
        }
        return listRetour;
    }

    public void sonnerOuverture()
    {
        
    }

    public void sonnerFermeture()
    {
        
    }

    public ArrayList<Klasse> getKlasses() {
        return klasses;
    }
}

class Individus {
    String nom;

    public Individus(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return nom;
    }
}

class Staff extends Individus {
    int salaire;

    public Staff(String nom) {
        super(nom);
        this.salaire = 0;
    }

    public Staff(String nom, int salaire) {
        super(nom);
        this.salaire = salaire;
    }
}

class Eleve extends Individus {
    CarnetNotes note = new CarnetNotes();

    public Eleve(String nom) {
        super(nom);
    }

    public String toString() {
        return String.format("Eleve(%s, %s)", this.nom, this.note);
    }

    public void ajouterNote( String matiere, int val )
    {
        this.note.ajouter( new Note( matiere, val )  );
    } 


    public void ouverture()
    {
        System.out.println( "sort ses cahiers" );
        System.out.println( "répond à l'appel" );
    }
}

class Prof extends Staff {
    public Prof(String nom, int salaire) {
        super(nom, salaire);
    }

    public void ouverture()
    {
        System.out.println( "sort sont cahier d'appel" );
        System.out.println( "fait l'appel" );
    }
}

class Cuisinier extends Staff {
    public Cuisinier(String nom, int salaire) {
        super(nom, salaire);
    }

    public void ouverture()
    {
        System.out.println( "regarder menu" );
        System.out.println( "sortir les ingrédients" );
        System.out.println( "allumer les fourneaux" );
    }

}

class Pion extends Staff {
    public Pion(String nom, int salaire) {
        super(nom, salaire);
    }

    public void ouverture()
    {
        System.out.println( "prends cahier appel" );
        System.out.println( "surveiller la cour" );

    }
}

/*
 *********************************************************************************************************** 
*/



class POOEcoleOne {
    // Xavier

    public static void main(String[] args) {


        Ecole jaures = new Ecole();

        // ajout des eleves
        jaures.ajouterPersonne(new Eleve("toto"));
        jaures.ajouterPersonne(new Eleve("tata"));
        jaures.ajouterPersonne(new Eleve("tutu"));
        jaures.ajouterPersonne(new Eleve("titi"));

        // ajout des prof
        jaures.ajouterPersonne(new Prof("Marie", 1700));
        jaures.ajouterPersonne(new Prof("Joseph", 1700));
        
        // ajout staff
        jaures.ajouterPersonne(new Cuisinier("René", 2000));

        // ajout des klasse
        jaures.ajouterKlasse( new Klasse( "primevère", "CE2",(Prof)jaures.chercherIndividus("Marie") ) );
        jaures.ajouterKlasse( new Klasse( "tulipe", "CP",(Prof)jaures.chercherIndividus("Joseph") ) );

        /*
         * =======================================================================
         */

        // ajout eleve dans une klasse
        Klasse handle;
        handle = jaures.chercherKlasse("primevère");
        handle.ajouterEleve( (Eleve)jaures.chercherIndividus("toto")  );
        handle.ajouterEleve( (Eleve)jaures.chercherIndividus("tata")  );
        /* 
        jaures.chercherKlasse("primevère").ajouterEleve( (Eleve)jaures.chercherIndividus("toto")  );
        jaures.chercherKlasse("primevère").ajouterEleve( (Eleve)jaures.chercherIndividus("tata")  );
        */

        // ajout eleve dans une klasse
        handle = jaures.chercherKlasse("tulipe");
        handle.ajouterEleve( (Eleve)jaures.chercherIndividus("titi")  );
        handle.ajouterEleve( (Eleve)jaures.chercherIndividus("tutu")  );

        System.out.println(  "==================================");

        jaures.chercherKlasse( "primevère").affiche();  
        jaures.chercherKlasse( "tulipe").affiche();  

        // Klasse klassTrouve = jaures.chercherKlasse( "primevère");
        // klassTrouve.affiche();  

        System.out.println(  "==================================");

        // chercher un eleve et lui donner des notes
        Eleve e1 = (Eleve)jaures.chercherIndividus( "titi" ); 
        e1.ajouterNote( "math", 12);
        e1.ajouterNote( "sport", 17);
        e1.ajouterNote( "français", 18);

        System.out.println( e1 );
        
        System.out.println(  "==================================");
        
        jaures.chercherKlasse( "tulipe").affiche();  

        System.out.println(  "==================================");


        Individus inconnu = jaures.chercherIndividus("totox");

        if ( inconnu != null && inconnu.getClass().getSimpleName().equals("Eleve")) {
            Eleve monEleve = (Eleve) inconnu;
            //monEleve.note += 10;
        }

        ArrayList<Eleve> lesEleves = jaures.listerEleve();
        for (Eleve eleve : lesEleves) {
            System.out.println(eleve);
        }
        
        //jaures.sonnerOuverture();
    }
}