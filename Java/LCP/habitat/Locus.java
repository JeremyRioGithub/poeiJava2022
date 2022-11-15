package habitat;

class Locus {
    private  String nom;
    public Locus(String nom){
        this.nom=nom;
    }
    public String toString() {
        return String.format("lieu : %s", this.nom);
    }
    
}
