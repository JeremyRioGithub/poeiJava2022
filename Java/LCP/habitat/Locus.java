package habitat;

import insecte.Insecte;

public class Locus {
    private  String nom;
    public Locus(String nom){
        this.nom=nom;
    }

    public String toString() {
        return String.format("lieu : %s (%s)", this.nom, this.getClass().getName());
    }

    public Boolean has(Insecte insecte) {
        String testedPlace = this.getClass().getName();
        String testedInsect = insecte.getClass().getName();
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
