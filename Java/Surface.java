public class Surface {

    public static String surface(int largeur, int longueur, double conversion)
    {
        return ("La surface du rectangle est de: "+largeur*longueur*conversion+" m2");
    }

    public static String surface(int cote, double conversion)
    {
        return ("La surface du carre est de: "+cote*cote*conversion+" m2");
    }

    public static String surface(double rayon, double conversion)
    {
        return ("La surface du disque est de: "+3.14*rayon*rayon*conversion+" m2");
    }

    public static double conversion(String mesure)
    {
        if (mesure=="cm")
        {
            return 0.0001;
        }
        else if (mesure=="dm")
        {
            return 0.01;
        }
        else
        {
            return 1;
        }
    }

    public static void main( String[] args) {
    System.out.println(surface(5,8,conversion("m")));
    System.out.println(surface(5,conversion("dm")));
    System.out.println(surface(7.5,conversion("cm")));
    }
    
}
