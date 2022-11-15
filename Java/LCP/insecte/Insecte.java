package insecte;

import habitat.Locus;

public class Insecte {
    private  String nom;
    public Insecte(String nom) {
        this.nom=nom;
    }

    public String toString() {
        return String.format("je suis : %s (%s)", this.nom, this.getClass().getName());
    }
    
    public Boolean liveIn(Locus locus) {
        String testedInsect = this.getClass().getName();
        String testedPlace = locus.getClass().getName();
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
