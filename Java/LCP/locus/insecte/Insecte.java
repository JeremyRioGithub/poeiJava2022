package locus.insecte;

import locus.Locus;
import locus.habitat.Habitat;

public class Insecte extends Locus{
    public Insecte(String nom) {
        super(nom);
    }

    public String toString() {
        return String.format("je suis : %s (%s)", this.nom, this.getClass().getName());
    }
    
    public Boolean liveIn(Habitat habitat) {
        String testedInsect = this.getClass().getName();
        String testedPlace = habitat.getClass().getName();
        System.out.println("Insecte: " + testedInsect + ", Place: " + testedPlace);
        if (testedInsect.equals("locus.insecte.Papillon") && testedPlace.equals("locus.habitat.Plaine")){
            return true;
        }
        else if (testedInsect.equals("locus.insecte.Papillon") && testedPlace.equals("locus.habitat.Alpage")){
            return true;
        }
        else if (testedInsect.equals("locus.insecte.Cigale") && testedPlace.equals("locus.habitat.Plaine")){
            return true;
        }
        else if (testedInsect.equals("locus.insecte.Atlantide") && testedPlace.equals("locus.habitat.Atlantide")){
            return true;
        }
        return false;
    }
}
