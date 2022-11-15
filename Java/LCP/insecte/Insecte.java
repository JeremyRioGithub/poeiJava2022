package insecte;

import habitat.*;

public class Insecte {
    private  String nom;
    public Insecte(String nom) {
        this.nom=nom;
    }

    public String toString() {
        return String.format("je suis : %s (%s)", this.nom, this.getClass().getName());
    }
    
    public Boolean liveIn(Locus locus) {
        return null ;
    }
}
