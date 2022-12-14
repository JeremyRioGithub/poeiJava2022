import java.util.ArrayList;


class Ligne {
    private String label    = "";
    private Double prixUnitaire       = 0.0;
    private Double quantite      = 0.0;

    static Integer nbrLigne = 0;
    private static Integer nbrArticles = 0;
    
    public Ligne (String nom, Double pu, Double qte) {
        this.label = nom;
        this.prixUnitaire = pu;
        this.quantite = qte;
    }
    public Integer setLigne (Integer value) {
        nbrLigne = value;
        return nbrLigne;
    }
    public void getLigne () {
        System.out.println(nbrLigne);
    }
    public Double getTotalLigne() {
        return this.prixUnitaire*this.quantite;
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
    private Double calculTotal() {
        Double res=0.0;
        for (Ligne l : lignes) {
            res += l.getTotalLigne();
        }
        return res;
    }

    public void afficher() {
        TicketNbr++;
        System.out.println(String.format("\nclient '%s' number %d: \t | ticket °%d", this.client, this.number,TicketNbr));
        for (Ligne l : lignes) {
            l.afficheLigne();
        }
        System.out.println(calculTotal());
    }

}

class TicketCaissePOO {

    public static void main(String[] args) {
        
        Ligne l1 = new Ligne("",0.0,0.0);
        l1.getLigne();

        Ticket t1 = new Ticket("toto", 5124);
        t1.addAchat(new Ligne("rutabaga", 1.0, 1.0));
        t1.addAchat(new Ligne("choux de Bruxelles", 2.0, 0.5));
        t1.addAchat(new Ligne("réglisse", 4.0, 0.25));
        t1.addAchat(new Ligne("bettes", 5.0, 0.2));
        t1.afficher();
        System.out.println(String.format("nbr Articles %d", Ligne.nbrLigne));
        
        l1.getLigne();
        l1.setLigne(0);
        l1.getLigne();
        //System.out.println(String.format("Nombre de Lignes: %d", l1.setLigne(0)));

        Ticket t2 = new Ticket("TONTON", 5125);
        t2.addAchat(new Ligne("ruby", 1500.0, 0.1));
        t2.addAchat(new Ligne("or", 2253.0, 0.78));
        t2.addAchat(new Ligne("mélasse", 0.5, 3354.0));
        t2.addAchat(new Ligne("diamant", 3325.0, 0.02));
        t2.afficher();
        System.out.println(String.format("nbr Articles %d", Ligne.nbrLigne));
        l1.getLigne();



        /*
       afficher nombre d'articles, 
       puis, afficher nombre de tickets.
        */
    }
}