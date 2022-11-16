import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// Jeremy, from Xavier
import java.util.HashMap;

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
        throw new EOFException();
    } 
}

class MaLigne {
    private String ligne;
    private String premierMot;

    public MaLigne(String ligne){
        this.ligne=ligne;
    }
    public String[] afficherListeMots(){
        String str[] = this.ligne.split("[\n.\t. (){},\\.]+");   
        //ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(str));  
        return str;
    }
    public String compterMotsParLigne(){
        String[] listeMots = this.ligne.split("[\n.\t. (){},\\.]+");
        String nbrMots = listeMots[listeMots.length -1];
        return nbrMots;
    }
    public String toString() {
        premierMot = this.ligne.split("[\n.\t. (){},\\.]+")[0];
        return String.format("premier mot de la ligne : %s", this.premierMot);
    }
}

public class  FichierFourPOOXavier {

    public static void ReadFileByLine() throws Exception{

        String file = "Figures.java";
        MyFileReader filereader = new MyFileReader(file);
        try {
                String ligne;
                HashMap<String, Integer> occurence = new HashMap<String, Integer>();
                //while ( true )
                int i = 0;
                while (i<3)
                {
                    i++;
                    ligne = filereader.readLine();
                    //MaLigne maLigne = new MaLigne(ligne);
                    //String[] listeMots =  maLigne.afficherListeMots();
                    String[] listeMots =  ligne.split("[\n.\t. ]+");
                    for (String chaqueMot : listeMots){
                        if (!chaqueMot.equals(" ") && chaqueMot.length()>0 && !chaqueMot.equals("Ã") && !chaqueMot.equals("//") && !chaqueMot.equals("\n") && !chaqueMot.equals("\t")){
                            //System.out.println(String.format("%s ", chaqueMot));
                            if (! occurence.containsKey(chaqueMot)){
                                occurence.put(chaqueMot, 1);
                            }
                            else {
                                occurence.put(chaqueMot, occurence.get(chaqueMot)+1);
                            }
                        }
                    }
                    for (String chaqueMot : occurence.keySet()){
                        System.out.println(chaqueMot +"\t"+ occurence.get(chaqueMot));
                    }
                }
        }
        
        catch (EOFException e) 
        {System.out.println( "fin du fichier" );}

        catch (Exception e) 
        {System.out.println( "une erreur s'est produite" );}

        finally 
        {
            System.out.println( "finally" );
            filereader.close();
        }
    }
    public static void main(String[] args) throws Exception
    {
        ReadFileByLine();      
    }    
}