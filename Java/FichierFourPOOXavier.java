import java.util.*;
import java.util.ArrayList.*;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// Jeremy, from Xavier

/* 
    Fichier texte (caractère + les controles)
        lire jusqua la fin quand on rencontre le caractere EOF

    Fichier binaire 
        connaitre la taille du fichier et puis le lire jusqu'à la fin 

*/


class MyException extends Exception
{

    public MyException()
    {
        super();
    }

}


class MyFileReader  extends FileReader
{
    static Integer EOF = -1;
    static Integer LF = 10;
    static int CR = 13;
    int caractereLuEnTrop; 

    public MyFileReader(String fileName ) throws FileNotFoundException
    {
        super( fileName );
    }

    public Boolean hasNext() throws IOException
    {

        if ( EOF == ( this.caractereLuEnTrop=this.read()) )
            return false;
        return true;
    }

    public String readLine() throws Exception
    {
        int caracter;

        String res = new String();
        res += (char)this.caractereLuEnTrop;

        while ( EOF != (caracter = this.read()) )
        {
            if ( caracter == LF )
                return res;
            else
                res += (char)caracter; 
        }
        throw new MyException();
    } 
}

public class  FichierFourPOO {
    // Xavier

    public static void main(String[] args) throws Exception
    {          

        String file = "Figures.java";
        //String file = args[0];
        MyFileReader filereader = new MyFileReader(file);
        try {
               
                int nbrLin = 1;
                String ligne;

                while ( true )
                {
                    ligne = filereader.readLine();
                    System.out.println( String.format("%4d : %s", nbrLin++, ligne ) );
                }
        }
        
        catch (MyException e) 
        {
            System.out.println( "fin du fichier" );
        }

        catch (Exception e) 
        {
            System.out.println( "une erreur s'est produite" );
            //e.printStackTrace();
        }

        finally 
        {
            System.out.println( "finally" );
            filereader.close();
        }
    }    
}