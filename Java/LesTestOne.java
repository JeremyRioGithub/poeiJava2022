// Bourget

class Atester 
{
    static public Integer calcul1( int var )
    {
        return 5 * var;
    }


    static public String presentation( String n )
    {  
        if (n.equals("")){
            return n;
        }
        String res = n.toUpperCase().charAt(0) +n.toLowerCase().substring(1);
        // Debug:
        //System.out.println(res);
        return res;
    }



} 


public class LesTestOne {
    public static void main( String[] args )
    {
        if ( Atester.calcul1( 3 ) == 15 )
            System.out.println( "OK" );

        if ( Atester.calcul1( 0 ) == 0 )
            System.out.println( "OK" );

        if ( Atester.calcul1( 1 ) == 5 )

        /* ******************************* */

        if ( Atester.presentation( "toto" ).equals( "Toto") )
            System.out.println( "OK" );
        else
            System.out.println( "KO" );
 
        if ( Atester.presentation( "TOTO" ).equals( "Toto") )
            System.out.println( "OK" );
        else
            System.out.println( "KO" );
 
        if ( Atester.presentation( "" ).equals( "") )
            System.out.println( "OK" );
        else
            System.out.println( "KO" );
 
        if ( Atester.presentation( "1234567890" ).equals( "1234567890") )
            System.out.println( "OK" );
        else
            System.out.println( "KO" );
    }    
}