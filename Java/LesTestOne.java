// Jeremy, from Bourget

class Atester {
    static public Integer calcul1(int var) {
        return 5 * var;
    }

    static public String presentation(String n) {
        if (n == null) {
            return n;
        } else if (n.length() == 0) {
            return n;
        } else {
            String res = n.toUpperCase().charAt(0) + n.toLowerCase().substring(1);
            // Debug:
            // System.out.println(res);
            return res;
        }
    }

    static public Boolean bisextile(Integer annee) {
        if (annee == null) {
            return null;
        } else if (annee % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void testString(String s1, String s2) {
        if ((s1!=null) && (s2!=null)){
            System.out.println(String.format("%s: %s == %s", s1.equals(s2) ? "OK": "KO", s1, s2));
        }
        else {
            System.out.println("OK: null == null");
        }
        
    }

    public static void testBoolean(Boolean b1, Boolean b2) {
        if (b1!=null)
            System.out.println(String.format("%s: %b == %b", b1 == b2 ? "OK": "KO", b1, b2));
        else 
            System.out.println("OK: null == null");
    }

}

public class LesTestOne {
    public static void main(String[] args) {

        if (Atester.calcul1(3) == 15)
            System.out.println("OK");

        if (Atester.calcul1(0) == 0)
            System.out.println("OK");

        if (Atester.calcul1(1) == 5)
            System.out.println("OK");

        /* ============================= */

        Atester.testString(Atester.presentation("toto"), "Toto");
        Atester.testString(Atester.presentation("TOTO"), "Toto");
        Atester.testString(Atester.presentation(""), "");
        Atester.testString(Atester.presentation("123456"), "123456");
        Atester.testString(Atester.presentation((String)null), null);
        
        Atester.testBoolean(Atester.bisextile(2020), true);
        Atester.testBoolean(Atester.bisextile(2021), false);
        Atester.testBoolean(Atester.bisextile(2022), false);
        Atester.testBoolean(Atester.bisextile(2023), false);
        Atester.testBoolean(Atester.bisextile((Integer)null), null);

    }
}