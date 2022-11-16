import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
// Jeremy, from Xavier
import java.util.HashMap;

class MyFileReader extends FileReader {
    static Integer EOF = -1;
    static Integer LF = 10;
    static int CR = 13;

    public MyFileReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public String readLine() throws Exception {
        int caracter;
        String res = new String();
        while (EOF != (caracter = this.read())) {
            if ((caracter == LF))
                return res;
            else
                res += (char) caracter;
        }
        throw new EOFException();
    }
}

public class FichierFourPOOXavier {

    public static void ReadFileByLine() throws Exception {

        String file = "Figures.java";
        MyFileReader filereader = new MyFileReader(file);
        HashMap<String, Integer> occurence = new HashMap<String, Integer>();
        try {
            String ligne;
            while (-1!=filereader.read())
            {
                ligne = filereader.readLine();
                String[] listeMots = ligne.split("[\n\t .\\s\"\\[\\](){};\\/\\,<>=+Ã\\-%']+");
                for (String chaqueMot : listeMots) {
                    if (chaqueMot.length() > 1 && !chaqueMot.equals(" ")) {
                        // affichage de chaque mot de >1 lettre du fichier lu:
                        //System.out.println(String.format("%s ", chaqueMot));
                        if (!occurence.containsKey(chaqueMot)) {
                            occurence.put(chaqueMot, 1);
                        } else {
                            occurence.put(chaqueMot, occurence.get(chaqueMot) + 1);
                        }
                    }
                }
                // le if suivant est necessaire pour afficher le résultat, sans quoi c'est l'exception EOFException qui prend le relai, et les occurences n'apparaissent pas.
                if (filereader.read()==-1){
                    System.out.println("fin de FICHIER");
                }
            }
            for (String chaqueMots : occurence.keySet()) {
                // affichage des occurrences
                System.out.println(String.format("%3d %3d %10s ", occurence.get(chaqueMots), chaqueMots.length() == 1 ? (int) chaqueMots.charAt(0) : 'X', chaqueMots));
            }
        }

        catch (EOFException e) {
            System.out.println("fin du fichier");
        }

        catch (Exception e) {
            System.out.println("une erreur s'est produite");
        }

        finally {
            System.out.println("finally");
            filereader.close();
        }
    }

    public static void main(String[] args) throws Exception {
        ReadFileByLine();
    }
}