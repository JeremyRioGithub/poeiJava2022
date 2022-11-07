public class Ligne2 {

    public static void Ligne(int largeur)
    {
        Ligne(largeur, "-", "+");
    }
    public static void Ligne(int largeur, String remplissage)
    {
        Ligne(largeur, remplissage, "|");
    }
    
    public static void Ligne(int largeur, String remplissage, String extremite)
    {
        System.out.print(extremite);
        for (int i=0; i<largeur; i++)
            System.out.print(remplissage);
        System.out.println(extremite);
    }
    public static void rectangleAuto(int largeur, int hauteur)
    {
        Ligne(largeur);
        //Ligne(largeur, "-", "+");
        for (int i=0; i<hauteur; i++)
            {
                Ligne(largeur, " ");
                //Ligne(largeur, " ", "|");
            }
        Ligne(largeur);
        //Ligne(largeur, "-", "+");
    }
    public static void main( String[] args) {
        rectangleAuto(4,3);
        for (int i=1; i<20; i=i*(-2))
        {
            System.out.println(i);
        }
    }
    
}
