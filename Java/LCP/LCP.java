import locus.*;
import locus.habitat.*;
import locus.insecte.*;

class LCP{
    public static void main(String[]args) {

        //test Ins liveIn Hab and Hab has Ins
        Alpage alpage = new Alpage("blanche");
        Plaine plaine = new Plaine("provence");
        Papillon papillon = new Papillon("bombyx");
        Cigale cigale = new Cigale("midi");
        locus.habitat.Atlantide atlantideHab = new locus.habitat.Atlantide("atlantide");
        locus.insecte.Atlantide atlantideIns = new locus.insecte.Atlantide("atlante");
        alpage.has(papillon);
        papillon.liveIn(alpage);
        System.out.println(plaine.has(cigale));
        System.out.println(atlantideHab.has(atlantideIns));
        System.out.println(atlantideHab.has(papillon));
        System.out.println(cigale.liveIn(plaine));
        
        //test through locus Ins linkedTo Hab
        Locus locus = new Locus("name");
        System.out.println(locus.linkedTo(plaine, cigale));
    }
}