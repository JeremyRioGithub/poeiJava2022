import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class MyException{
    public MyException(){
        super();
    }
}

class MonFileReader extends FileReader {
    static int EOF = -1;
    static int LF = 10;
    int caractereLuEnTrop;

    public MonFileReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public Boolean hasNext() throws IOException {
        if (EOF == (this.caractereLuEnTrop=this.read()))
            return false;
        return true;
    }

    public String readLine() throws Exception {
        int c;
        String res = new String();
        res+= (char)this.caractereLuEnTrop;

        while (EOF != (c = this.read())) {
            if (c == LF) {
                return res;
            } else
                res += (char)c;
        }
        throw new EOFException();
    }
}

public class FichierTwo {

    public static void readFileByLine(String file) throws IOException {
        MonFileReader filereader = new MonFileReader(file);
        try {
            int nbrLine = 1;
            String ligne;

            while (true) {
                ligne = filereader.readLine();
                System.out.print(String.format("\n%4d : %s", nbrLine++, ligne));
                //if (ligne=="***=(=XOxo-EOF-oxOX=)=***")
                //    break;
            }
        } catch (Exception e) {
            System.out.println("erreur");
            e.printStackTrace();
        } finally {
            System.out.println("fermeture fichier");
            filereader.close();
        }
    }

    public static void readFileByChar(String file) {
        int EOF = -1;
        // int CR=13;
        int LF = 10;
        try {
            FileReader filereader = new FileReader(file);
            int c;
            int nbrLine = 1;
            int NbrCar = 0;
            System.out.print(String.format("\n%4d : ", nbrLine));

            while (EOF != (c = filereader.read())) {
                if (c == LF) {
                    nbrLine++;
                    System.out.print(String.format("\n%4d : ", nbrLine));
                } else
                    System.out.print((char) c);
                NbrCar++;
            }

            System.out.println("");
            System.out.println("nombreChar: " + NbrCar);
            System.out.println("nombreLignes: " + nbrLine);
            filereader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //readFileByChar("Figures.java");
        readFileByLine("Figures.java");

    }
}
