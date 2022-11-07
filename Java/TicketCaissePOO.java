import java.util.ArrayList;


class Ligne {
    String label    = "";
    Double prixUnitaire       = 0.0;
    Double quantite      = 0.0;

    static Integer nbrLigne = 0;
    static Integer nbrArticles = 0;
    
    public Ligne (String nom, Double pu, Double qte) {
        this.label = nom;
        this.prixUnitaire = pu;
        this.quantite = qte;
    }
    public Integer setLigne (Integer value) {
        nbrLigne = value;
        return nbrLigne;
    }

    public void afficheLigne() {
        nbrLigne++;
        nbrArticles++;
        System.out.println(String.format("Ligne n°%d | %20s | PU:%8.2f | QU:%8.2f", nbrLigne, this.label, this.prixUnitaire, this.quantite));
    }

}


class Ticket {
    String client    = "";
    Integer number = 0 ;
    Double prixTot  = 0.0;
    ArrayList<Ligne> lignes  = new ArrayList<>();
    
    static Integer TicketNbr = 0;

    public Ticket (String nom, Integer numero) {
        this.client = nom;
        this.number = numero;
    }

    public void addAchat(Ligne l){
        lignes.add(l);
    }

    public void afficher() {
        TicketNbr++;
        System.out.println(String.format("\nclient '%s' number %d: \t | ticket °%d", this.client, this.number,TicketNbr));
        for (Ligne l : lignes) {
            l.afficheLigne();
        }
    }

}

class TicketCaissePOO {

    static ArrayList<Ligne> lignes  = new ArrayList<>();

    public static void main(String[] args) {

        
        Ticket t1 = new Ticket("toto", 5124);
        t1.addAchat(new Ligne("rutabaga", 1.5, 5.0));
        t1.addAchat(new Ligne("choux de Bruxelles", 4.50, 1.0));
        t1.addAchat(new Ligne("réglisse", 3.0, 2.1));
        t1.addAchat(new Ligne("bettes", 2.4, 1.0));
        t1.afficher();
        System.out.println(String.format("nbr Articles %d", Ligne.nbrLigne));
        
        Ligne l1 = new Ligne("",0.0,0.0);
        l1.setLigne(0);
        //System.out.println(String.format("Nombre de Lignes: %d", l1.setLigne(0)));

        Ticket t2 = new Ticket("TONTON", 5125);
        t2.addAchat(new Ligne("ruby", 1500.0, 0.1));
        t2.addAchat(new Ligne("or", 2253.0, 0.78));
        t2.addAchat(new Ligne("mélasse", 0.5, 3354.0));
        t2.addAchat(new Ligne("diamant", 3325.0, 0.02));
        t2.afficher();
        System.out.println(String.format("nbr Articles %d", Ligne.nbrLigne));


        /*
       afficher nombre d'articles, 
       puis, afficher nombre de tickets.
        */
    }
}