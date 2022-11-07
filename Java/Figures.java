class Figures{

    public static void drawVoidsOrStars(int value, int hauteur) // ajoute autant de vides que value/2 en s'initialisant à la valeur max puis en diminuant de tour en tour. Sera fait avant et apres l'affichage des etoiles, donc au final on aura autant de vides que d'etoiles
    {
        for (int k=hauteur/2; k>value/2; k--)
            System.out.print(" ");
    }
    public static void drawVoidsOrStars(int value) // ajoute autant d'etoiles que la valeur "value"
    {
        for (int j=0; j<=value; j++) // ajoute autant d'etoiles que la valeur "value"
            System.out.print("*");
    }
    public static void drawReverseTriangle(int hauteur) // fait la partie basse du sablier
    {
        hauteur=hauteur-1; // permet de lancer la commande avec la valeur 0
        for (int i=hauteur;i>0;i=i-2) // d'une ligne à l'autre il y a deux etoiles de moins
        {
            oneLine(i, hauteur); // ajoute les lignes de vides et d'etoiles
        }
    }
    public static void drawTriangle(int hauteur) // fait la partie basse du sablier
    {
        hauteur=hauteur-1; // permet de lancer la commande avec la valeur 0
        int i=hauteur%2; // definit i à 0 ou 1 en fonction de hauteur, qu'il soit pair ou impair
        for (;i<=hauteur;i=i+2) // d'une ligne à l'autre il y a deux etoiles de plus
        {
            oneLine(i, hauteur); // ajoute les lignes de vides et d'etoiles
        }
    }
    public static void oneLine(int i, int hauteur) // creates a line with voids and stars
    {
        drawVoidsOrStars(i, hauteur); // ajoute les vides
        drawVoidsOrStars(i); // ajoute les etoiles
        //drawVoidsOrStars(i, hauteur); // ajoute les vides
        System.out.println(""); // retour ligne
    }
    public static void buildHourGlass(int hauteurInit) // ajoute la partie haute puis la partie basse du sablier
    {
        drawReverseTriangle(hauteurInit); //ajoute la partie haute
        drawTriangle(hauteurInit); // ajoute la partie basse
    }
    public static void main(String[] args){
        buildHourGlass(100); // lance le programme qui affiche un sablier de taille "hauteurInit"

    }
}