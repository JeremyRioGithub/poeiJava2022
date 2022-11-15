// Jeremy, from Bourget

class Atester {
    static public Integer calcul1(int var) {
        return 5 * var;
    }
    
    static public String presentation(String n) {
        if (n==null){
            return n;
        }
        else if (n.length()==0) {
            return n;
        }
        else{
            String res = n.toUpperCase().charAt(0) + n.toLowerCase().substring(1);
            // Debug:
            // System.out.println(res);
            return res;
        }
    }

    static public Boolean bisextile(Integer annee) {
        if (annee==null){
            return null;
        }
        else if (annee%4==0){
            return true;
        }
        else {
            return false;
        }
    }

}

public class LesTestOne {
    public static void main(String[] args) {
        
        if (Atester.calcul1(3) == 15)
            System.out.println("OK");

        if (Atester.calcul1(0) == 0)
            System.out.println("OK");

        if (Atester.calcul1(1) == 5)

        if (Atester.presentation("toto").equals("Toto"))
            System.out.println("OK");
        else
            System.out.println("KO");

        if (Atester.presentation("TOTO").equals("Toto"))
            System.out.println("OK");
        else
            System.out.println("KO");

        if (Atester.presentation("").equals(""))
            System.out.println("OK");
        else
            System.out.println("KO");

        if (Atester.presentation("1234567890").equals("1234567890"))
            System.out.println("OK");
        else
            System.out.println("KO");

        String s1=null;
        if (Atester.presentation(s1)==null)
            System.out.println("OK");
        else
            System.out.println("KO");

        Integer i1=null;
        if (Atester.bisextile(i1) == null)
            System.out.println("OK");
        else
            System.out.println("KO");

        if (Atester.bisextile(2020).equals(true))
            System.out.println("OK");
        else
            System.out.println("KO");

        if (Atester.bisextile(2021).equals(false))
            System.out.println("OK");
        else
            System.out.println("KO");

        if (Atester.bisextile(2022).equals(false))
            System.out.println("OK");
        else
            System.out.println("KO");

        if (Atester.bisextile(2023).equals(false))
            System.out.println("OK");
        else
            System.out.println("KO");
    }
}