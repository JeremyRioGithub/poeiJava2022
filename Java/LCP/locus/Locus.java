package locus;

import locus.habitat.Habitat;
import locus.insecte.Insecte;

public class Locus {
    protected String nom;
    
    public Locus(String nom) {
        this.nom = nom;
    }

    public Boolean linkedTo(Habitat habitat, Insecte insecte) {
        String testedInsect = insecte.getClass().getName();
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
