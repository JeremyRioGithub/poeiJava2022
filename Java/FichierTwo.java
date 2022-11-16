import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class MonFileReader extends FileReader {
    int EOF = -1;
    int LF = 10;
    
    public MonFileReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public String readLine() throws IOException {
        int c;
        String res = "";
        while (EOF != (c = this.read())) {
            if (c == LF) {
                return res;
            } else
                res += (char) c;
        }
        return "=(=XOxo-EOF-oxOX=)="; // monEOF
    }
}

public class FichierTwo {

    public static void readFileByLine() {
        String file = "Figures.java";
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

    public static void readFileByChar() {
        String file = "Figures.java";
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

    public static void main(String[] args) throws IOException {
        // readFileByChar();
        // readFileByLine();

    }
}
