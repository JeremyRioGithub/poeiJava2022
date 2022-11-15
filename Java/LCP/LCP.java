import habitat;
import insecte;

class LCP{
    public static void main(String[]args) {
        Montagne mo1 = new Montagne("blanche");
        Plaine pl1 = new Plaine("provence");
        Papillon pa1 = new Papillon("bombyx");
        Cigale ci1 = new Cigale("midi");
        mo1.has(pa1);
        pa1.liveIn(mo1);
        pl1.has(ci1);
        ci1.liveIne(pl1);
    }
}