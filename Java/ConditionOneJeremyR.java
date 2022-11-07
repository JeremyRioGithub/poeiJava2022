import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ConditionOneJeremyR {

    static ArrayList<String> nomsL = new ArrayList<String>();
    static ArrayList<String> sportsL = new ArrayList<String>();

    static Map<String, String> dictionaryNomSport = new HashMap<String, String>();

    public static void ajouteNomEtSportL(String nom, String sport)
    {
        nomsL.add(nom);
        sportsL.add(sport);
    }
    public static String quelSportFaitL(String nom)
    {
        int indexSport = nomsL.indexOf(nom);
        String sport = sportsL.get(indexSport);
        return sport;
    }
    public static void main(String[] args)
    {
        ajouteNomEtSportL("toto", "tennis");
        ajouteNomEtSportL("jean", "velo");
        dictionaryNomSport.put("toto", "tennis");
        dictionaryNomSport.put("jean", "velo");

        // prenom demande
        String prenom = "toto";

        // appels de methodes en fonction du type de solution
        String sportL = quelSportFaitL(prenom);
        String sportD = dictionaryNomSport.get(prenom);

        //solutions avec conteneur, puis dictionnaire, puis...
        System.out.println(String.format("%s fait %s", prenom, sportL));
        System.out.println(String.format("%s fait %s", prenom, sportD));
    }
}

/*
toto -> tennis
jean -> velo
Sigismond -> joute
Gontrand -> bridge
titi -> ski
*/