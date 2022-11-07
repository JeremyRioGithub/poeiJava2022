import java.util.ArrayList;

class ListeCourses2 {

    // creation des list qui vont contenir les données
    static ArrayList<String> noms = new ArrayList<String>();
    static ArrayList<Double> prixs = new ArrayList<Double>();
    static ArrayList<Double> quantites = new ArrayList<Double>();

    public static void addArticle(String nom, Double prix, Double qte) {
        noms.add(nom);
        prixs.add(prix);
        quantites.add(qte);
    }

    public static double affArticle(int i) {
        double totalPrix = prixs.get(i) * quantites.get(i);
        System.out.println(String.format("%2d -> %20s    %6.2f  %5.2f   %8.2f", i + 1, noms.get(i), prixs.get(i),
                quantites.get(i), totalPrix));
        return totalPrix;
    }

    public static void afficheTicket() {
        double totalPrix = 0.0;
        for (int i = 0; i < noms.size(); i++)
            totalPrix += affArticle(i);
        System.out.println(String.format("montant Total %7.2f", totalPrix));
    }

    public static void main(String[] args) {

        addArticle("romarin", 7.56, 1.0);
        addArticle("rutabaga", 1.5, 5.0);
        addArticle("choux de Bruxelles", 4.50, 1.0);
        addArticle("réglisse", 8.75, 0.5);
        addArticle("bettes", 2.4, 1.0);

        afficheTicket();
    }
}