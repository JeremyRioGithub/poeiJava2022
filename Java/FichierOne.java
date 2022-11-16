import java.io.FileReader;
import java.io.IOException;

public class FichierOne {

    public static void readFileByChar(){
        String file = "Figures.java";
        int EOF=-1;
        //int CR=13;
        int LF=10;
        try {
            FileReader filereader = new FileReader(file);
            int c;
            int nbrLine= 1;
            int NbrCar = 0;
            System.out.print(String.format("\n%4d : ", nbrLine));

            while (EOF != (c=filereader.read())){
                if (c==LF){
                    nbrLine++;
                    System.out.print(String.format("\n%4d : ", nbrLine));
                }
                else
                    System.out.print((char)c);
                NbrCar++; 
            }

            System.out.println("");
            System.out.println("nombreChar: "+NbrCar);
            System.out.println("nombreLignes: "+nbrLine);
            filereader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException{
        readFileByChar();
    }
}
