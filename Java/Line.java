import java.util.TimerTask;

class Line extends TimerTask{
    public static void lineSpecial( int longueur, String texteCadre, String texteVide, String texteEcrit, int yaxis, String characterName, int height) 
    {
        System.out.print( texteCadre );
        for (int j=1; j< longueur-1 ;j++)
                {
                    if (j==yaxis && characterName=="counterSlash") // counterSlash
                    {
                        System.out.print( texteEcrit );
                    }
                    else if (j==(longueur-yaxis-1) && characterName=="slash") // slash
                    {
                        System.out.print( texteEcrit );
                    }
                    else if (j==((longueur-1)/2) && characterName=="midVertical") // slash
                    {
                        System.out.print( texteEcrit );
                    }
                    else if (yaxis==(height/2) && characterName=="midHorizontal") // slash
                    {
                        System.out.print( texteEcrit );
                    }
                    else
                    {
                        System.out.print( texteVide );
                    }
                }
        System.out.println( texteCadre );
    }
    public static void lineNormal( int longueur, String texteCadre, String texteVide) 
    {
        System.out.print( texteCadre );
        for (int j=1; j< longueur-1 ;j++)
            System.out.print( texteVide );
        System.out.println( texteCadre );
    }
    public static void rectangle(int largeur, int hauteur, String backgroundText, String contentText, String iconName) 
    {
        for (int i=0; i< hauteur ;i++) 
        {
            if (i==0 || i==hauteur-1) {
                lineNormal( largeur, "+", "-");
            }
            else 
            {
                lineSpecial( largeur, "|", backgroundText, contentText, i, iconName, hauteur);
            }
        }
    }
    public void run(){
            //rectangle(10, 10, " ", "o", "counterSlash");
            //rectangle(10, 10, " ", "o", "midVertical");
            //rectangle(10, 10, " ", "o", "slash");
            //rectangle(10, 10, " ", "o", "midHorizontal");
        }
    public static void main(String[] args) throws Exception {
        rectangle(10, 10, " ", "o", "counterSlash");
        rectangle(10, 10, " ", "o", "slash");
        rectangle(10, 10, " ", "o", "midVertical");
        rectangle(10, 10, " ", "o", "midHorizontal");
        rectangle(10, 10, " ", "o", "none");
    }
}

