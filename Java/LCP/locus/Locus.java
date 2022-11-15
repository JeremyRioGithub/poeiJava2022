package locus;

import locus.habitat.Habitat;
import locus.insecte.Insecte;

public class Locus {
    protected String nom;
    
    public Locus(String nom) {
        this.nom = nom;
    }

    public Boolean linkedTo(Habitat habitat, Insecte insecte) {
        String testedInsect = this.getClass().getName();
        String testedPlace = habitat.getClass().getName();
        System.out.println("Insecte: " + testedInsect + ", Place: " + testedPlace);
        if (testedInsect.equals("insecte.Papillon") && testedPlace.equals("habitat.Plaine")){
            return true;
        }
        else if (testedInsect.equals("insecte.Papillon") && testedPlace.equals("habitat.Alpage")){
            return true;
        }
        else if (testedInsect.equals("insecte.Cigale") && testedPlace.equals("habitat.Plaine")){
            return true;
        }
        else if (testedInsect.equals("insecte.Atlantide") && testedPlace.equals("habitat.Atlantide")){
            return true;
        }
        return false;
    }
}
