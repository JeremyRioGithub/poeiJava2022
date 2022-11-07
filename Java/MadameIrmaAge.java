import java.util.ArrayList;

class MadameIrmaAge {
    // Jeremy d'apres Xavier

    static ArrayList<String> preoccupations = new ArrayList<String>();

    public static int numeroDeLaChanceM(String prenom) {
        prenom = prenom.toLowerCase();
        int resultat = 0;
        for (int i = 0; i < prenom.length(); i++) {
            int charactere = prenom.charAt(i) - (int) 'a' + 1;
            resultat += charactere;
        }
        return resultat % 50;
    }

    public static void preoccupationM(int age) {
        if (age <= 20) {
            if (age <= 12)
                preoccupations.add("ecole");
            else
                preoccupations.add("trucs d'ados");
        } 
        else {
            if (age <= 40)
                preoccupations.add("enfants");
            if (age <= 30)
                preoccupations.add("conjoint");
            if (age <= 65)
                preoccupations.add("travail");
            if (age > 60)
                preoccupations.add("la retraite");
        }

    }

    public static void main(String[] args) {

        String prenom = "Gertrude";
        int age = 61;
        int numDeChance = numeroDeLaChanceM(prenom);
        preoccupationM(age);
        System.out.println(String.format("le numéro de la chance de %s est %d, et preoccupation est %s", prenom,
                numDeChance, preoccupations));
    }
}
/*
 * 
 * 0-12 ans ecole
 * 12-20 ans trucs d'ados
 * 20-65 ans travail
 * 20-40 ans enfants
 * 20-30 ans conjoint
 * 60+ la retraite
 * 
 */
