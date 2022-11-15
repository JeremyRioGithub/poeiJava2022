import habitat.*;
import insecte.*;

public class LCP{
    public static void main(String[]args) {
        Alpage al1 = new Alpage("blanche");
        Plaine pl1 = new Plaine("provence");
        Papillon pa1 = new Papillon("bombyx");
        Cigale ci1 = new Cigale("midi");
        al1.has(pa1);
        pa1.liveIn(al1);
        pl1.has(ci1);
        ci1.liveIn(pl1);
    }
}