public class Fonction { // on cree des fonctions
    
    public static int somme( int p1, int p2)
    {
        return p1+p2;
    }
    public static String surface(int largeur, int longueur) // on declare un string car ce qui est renvoyé est un str
    {
        return "surface du rectangle (= " +largeur+"*"+longueur+"): "+(largeur*longueur)+ "";
    }   
    public static String disBonjour(String prenom)
    {
        return "Coucou "+prenom+" ?";
    }
    public static String disBonjour()
    {
        return "Coucou, tu veux voir Magritte ?";
    }
    public static String disBonjour(int age)
    {
        return "Coucou, tu as "+age+" ans.";
    }
    public static String disBonjour(int age, String prenom)
    {
        return "Coucou "+prenom+", tu as "+age+" ans.";
    }
    public static void main( String[] args) {
        //System.out.println(args[0]); // ces arguments n'existent que quand sont appelés que lors de l'appel de la classe Fonction en lui donnant des arguments. Exemple: java Fonction "blabla", "blabla" sera alors affiché.
        int resultat = somme(5,2);
        System.out.println(resultat);
        System.out.println(surface(5,2));
        System.out.println(disBonjour("Jeremy"));
        System.out.println(disBonjour());
        System.out.println(disBonjour(18));
        System.out.println(disBonjour(18, "jeremy"));
    }
    
}
