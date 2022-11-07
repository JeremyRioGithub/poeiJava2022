import java.util.HashMap;
import java.util.Map;

class ConditionOneDictionnaryJeremy {
    static Map<String, String> dictionaryNomSport = new HashMap<String, String>();
    public static void main(String[] args)
    {
        dictionaryNomSport.put("toto", "tennis");
        dictionaryNomSport.put("jean", "velo");

        for (String nom : dictionaryNomSport.keySet()) {
            String sport = dictionaryNomSport.get(nom);
            System.out.println(String.format("%s a comme sport %s", nom,sport));
        }
        //String prenom = args[0];
        String prenom = "toto";
        prenom = prenom.toLowerCase();
        String sportD = dictionaryNomSport.get(prenom);
        if (sportD!="null")
        {
            System.out.println(String.format("%s fait %s", prenom, sportD));
        }
        else{
            System.out.println("Il faut entrer un prenom connu.");
        }
        System.out.println(sportD!="null" ? String.format("%s fait %s", prenom, sportD) : "Il faut entrer un prenom connu.");
    }
}

/*
toto -> tennis
jean -> velo
Sigismond -> joute
Gontrand -> bridge
titi -> ski
*/