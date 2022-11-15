package locus.habitat;

import locus.Locus;
import locus.insecte.Insecte;

public class Habitat extends Locus{
    public Habitat(String nom){
        super(nom);
    }

    public String toString() {
        return String.format("lieu : %s (%s)", this.nom, this.getClass().getName());
    }

    public Boolean has(Insecte insecte) {
        String testedPlace = this.getClass().getName();
        String testedInsect = insecte.getClass().getName();
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
