// Le programme est encapsulé dans une classe, dont le nom commence par une majuscule
class Variable 
{ // Methode et fonction c'est pareil, donc quand je fais une fonctionvdans une classe, je fais une methode
    //Toujours Objets dans la classe
    public static void main(String [] args) // public pour pouvoir l'appelr de l'exterieur à Toto, ne renvoie rien , recois des arg ou pas, 
    {
        // declaration de variable, ici un entier.
        int temperature= 19; // codé sur 32 bit, 0-65535.
        // declaration de variable, ici un String.
        String temperatureStr= "dix-neuf"; // suite de char.
        // declaration de variable, ici un float. (necessite un f apres la valeur, sinon il faut declarer un double)
        float temperatureFlt= 19.16f;
        // declaration d'un charactere, ressemble au type ASCII
        char uneLettre = 'z'; // stocké sur 2 bytes, soit 16 bits

        int largeur = 45;
        double longueur = 36.5;
        double surface = largeur*longueur;


        System.out.println("La temperature est de "+temperature+" degres.");
        System.out.println("encore écrit "+temperatureStr+" degres.");
        System.out.println("Elle est plus précisément de "+temperatureFlt+" degres.");
        System.out.println("Une lettre, ici c'est : "+uneLettre+"");
        System.out.println("La surface d'un rectangle de longueur "+longueur+" et de largeur "+largeur+" est de "+surface);
        System.out.println(longueur+largeur); // renvoie la somme des deux !
        System.out.println(""+longueur+largeur); // renvoie le texte des deux concatenes, car string prend la priorite !
        System.out.println(""+(longueur+largeur)); // renvoie la somme des deux, car la parenthese prend la priorité sur le string
    }

}
