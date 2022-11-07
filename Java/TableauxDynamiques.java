import java.util.ArrayList;

class TableauxDynamiques {

    // create dynamic array that is available in the whole class
    static ArrayList<String> oiseauxs = new ArrayList<String>();

    public static void displayList(ArrayList<String> listes)
    {
        // display listes content
        System.out.println(listes);
        // get and display array size
        int sizeOfArray = listes.size();
        System.out.println(sizeOfArray);
        // display content of listes line per line with specific format
        for (String liste : listes)
        {    
            System.out.println(String.format("n° %d : %s",listes.indexOf(liste)+1 , liste));
            //System.out.println("n° %d : %s".format(listes.indexOf(liste)+1 , liste));
        }

    }
    public static void main(String[] args) {
        // create dynamic array that is restrained to the main
        ArrayList<String> poissons = new ArrayList<String>();
        // fill array
        poissons.add("sardines");
        poissons.add("dauphin");
        poissons.add("morue");
        poissons.add("bar");
        oiseauxs.add("corbeau");
        oiseauxs.add("kiwi");
        oiseauxs.add("canard");
        // display with method displayList
        displayList(poissons);
        // display with method displayList
        displayList(oiseauxs);
    }
}