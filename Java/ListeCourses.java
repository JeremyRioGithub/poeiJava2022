import java.util.ArrayList;

class ListeCourses {
    
    static ArrayList<String> noms = new ArrayList<>();
    static ArrayList<Double> prixs = new ArrayList<>();
    static ArrayList<Double> quantites = new ArrayList<>();
    
    public static void addArticles (String label, double price, double qty)
    {
        noms.add(label);
        prixs.add(price);
        quantites.add(qty);
    }

    public static String affArticles(int i)
    {
            return String.format("article n°%2d -> %10s %,7.2f %7.2f %7.2f\n", i+1, noms.get(i), prixs.get(i), quantites.get(i), prixs.get(i)*quantites.get(i));

    }

    public static void printBill()
    {
        System.out.print(String.format("%12s -> %10s %7s %7s %7s\n", "labelNbr", "label", "PU", "qte", "PT"));
        System.out.println("---------------------------------------------------------------------");
    
        for (int i=0; i<noms.size(); i++)
            System.out.print( affArticles(i));
                
            double Total = 0;
            for (int i=0; i<prixs.size(); i++)
                Total += prixs.get(i)*quantites.get(i);
    
            System.out.print(String.format("\nVendeur: \t\"Ca fera %,.2f. Ce sera tout ?\"\n\n",Total));
    
    }
    public static void main(String[] args)
    {
        addArticles("patate", 1.0, 3.58);
        addArticles("oignon", 3.5, 8.0);
        
        //Scanner saisieUtilisateur = new Scanner(System.in);
        printBill();
    }
}

