class LoopAlgoTriangle{

    public static int dessineTriangle(int hauteur)
    {
        int compteur=0;
        for (int i=0;i<hauteur;i++)
        {
            for (int j=0; j<=i; j++)
                {
                    System.out.print("*");
                    compteur++;
                }
            System.out.println("");
        }
        return compteur;
    }
    public static int compteEtoile(int hauteur)
    {
        return hauteur*(hauteur+1)/2;
    }
    public static void main(String[] args){
        int compteurStar=0;
        for (int i=0;i<10;i++)
        {
            for (int j=0; j<=i; j++)
                {
                    compteurStar++;
                    System.out.print("*");
                }
            System.out.print(compteurStar);
            System.out.println("");
        }
        System.out.println(compteurStar);

        dessineTriangle(5);
        System.out.println(compteEtoile(5));

    }
}