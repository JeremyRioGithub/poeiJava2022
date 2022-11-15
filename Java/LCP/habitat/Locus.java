package habitat;

import insecte.*;

public class Locus {
    private  String nom;
    public Locus(String nom){
        this.nom=nom;
    }
    public String toString() {
        return String.format("lieu : %s (%s)", this.nom, this.getClass().getName());
    }

    public Boolean has(Insecte insecte) {
        return null;
    }
    
}
