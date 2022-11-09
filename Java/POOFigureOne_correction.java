
class PointCorr
{
    Integer x, y;

    public PointCorr( Integer x, Integer y )
    {
        this.x = x;
        this.y = y;
    }

    public void affiche()
    {
        System.out.println( String.format( "PointCorr : (%d, %d)", this.x, this.y ) );
    }
}

class Cercle extends PointCorr
{
    Integer rayon;

    public Cercle( Integer x, Integer y, Integer r )
    {
        super(x, y);
        this.rayon = r;
    }

    public void affiche()
    {
        System.out.println( String.format( "Cercle : (%d, %d) rayon=%d", this.x, this.y, this.rayon ) );
    }
}




class  POOFigureOne_correction {
    // Xavier

    public static void main(String[] args) 
    {

        PointCorr p1 = new PointCorr( 5, 6 );
        p1.affiche();
        // (5, 6)

        Cercle c1 = new Cercle( 11, 61, 45 );
        c1.affiche();
        // (5, 6)

        Carre k1 = new Carre( 18, 3, 15 );
        k1.affiche();
        // Carre : (5, 6) cote=15
        Rectangle r1 = new Rectangle( 3, 19, 99, 18 );
        r1.affiche();
        // Rectangle : (5, 6) long=99 lar=18
    }
}