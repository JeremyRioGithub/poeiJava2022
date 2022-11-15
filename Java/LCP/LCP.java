import habitat.*;
import insecte.*;

class LCP{
    public static void main(String[]args) {
        Alpage alpage = new Alpage("blanche");
        Plaine plaine = new Plaine("provence");
        Papillon papillon = new Papillon("bombyx");
        Cigale cigale = new Cigale("midi");
        habitat.Atlantide atlantideHab = new habitat.Atlantide("atlantide");
        insecte.Atlantide atlantideIns = new insecte.Atlantide("atlante");
        alpage.has(papillon);
        papillon.liveIn(alpage);
        System.out.println(plaine.has(cigale));
        System.out.println(atlantideHab.has(atlantideIns));
        System.out.println(atlantideHab.has(papillon));
        System.out.println(cigale.liveIn(plaine));
    }
}