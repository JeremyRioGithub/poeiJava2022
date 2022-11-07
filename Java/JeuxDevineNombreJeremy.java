import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class JeuxDevineNombreJeremy {
        // Jeremy

        public static Scanner saisieJeu; 
        public static ArrayList<String> reponses = new ArrayList<String>(Arrays.asList("yes", "y", "o", "si", "ye", "oui", "ou", "da"));
         
        public static void lancerJeu() {
                int numeroChoisi = -1;
                int nbEssai = 1;
                int nbEssaiSaisie = 1;
                int valMin = 1;
                int valMax = 10;
                int randomNum = ThreadLocalRandom.current().nextInt(valMin, valMax + 1);
                //Scanner saisieJeu = new Scanner(System.in);
                while (nbEssai <= 3) {
                        System.out.print("Entrez votre numero (entre " + valMin + "et " + (valMax) + "): ");
                        String numeroSaisi = saisieJeu.nextLine();
                        // determine si l'entree n'est pas un chiffre et s'arrete.
                        try {
                                numeroChoisi = Integer.parseInt(numeroSaisi);
                        } catch (NumberFormatException nfe) {
                                System.out.println("Il faut un chiffre");
                                if (nbEssaiSaisie >= 3) {
                                        System.out.println("laisse tomber...");
                                        break;
                                }
                                nbEssaiSaisie++;
                                continue;
                        }
                        System.out.println(String.format("DEBUG: SOLUCE: numeroChoisi: %d,vraiNumero: %d, nbEssai: %d", numeroChoisi,randomNum, nbEssai));
                        if (randomNum > numeroChoisi)
                                System.out.println("---trop petit");
                        else if (randomNum < numeroChoisi)
                                System.out.println("---trop grand");
                        else {
                                System.out.println("---BRAVO, fait en " + nbEssai + "essais");
                                break;
                        }
                        nbEssai++;

                }
                if (nbEssai > 3) {
                        System.out.println("PERDU, c'était " + randomNum);
                }
        }
        public static void multiPartie()
        {
                System.out.println("---lancer jeu ? : (yes, y, o, si, ye, oui, ou, da)");
                saisieJeu = new Scanner(System.in);
                String reponse = saisieJeu.nextLine();
                if (reponses.indexOf(reponse)!=-1) {
                        while (true) {
                                System.out.println("---c'est parti.");
                                lancerJeu();
                                System.out.println("---nouveau jeu ? : (yes, y, o, si, ye, oui, ou, da)");
                                reponse = saisieJeu.nextLine();
                                if (reponses.indexOf(reponse)==-1)
                                        break;
                        }
                }
                System.out.println("---merci. A bientot.");
        }       
        public static void main(String[] args) {

                multiPartie();
                saisieJeu.close();
        }

}