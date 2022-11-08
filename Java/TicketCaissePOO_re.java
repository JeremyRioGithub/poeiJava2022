import java.util.ArrayList;

class Article {
    // Jeremy: je refais le ticket de caisse pour mieux comprendre la mécanique de l'orienté objet.
    String name = "";
    Double unitPrice = 0.0;
    Double quantity = 0.0;
    Integer barCode = 0;
    public Article(String nom, Double pu, Double qte) {
        this.name = nom;
        this.unitPrice = pu;
        this.quantity = qte;
    }
    public void afficherArticle(){
        this.barCode++;
        System.out.println(String.format("%20s-%d: %8.2fE * %8.2f = %8.2f", this.name, this.barCode, this.unitPrice, this.quantity, this.unitPrice*this.quantity));
    }
}

class Client {
    ArrayList<Article> listArticles = new ArrayList<>();
    String name = "";
    Integer identifier = 0;
    public Client(String nom, Integer id) {
        this.name = nom;
        this.identifier = id;
    }
    public void ajouterArticle(Article a1){
        listArticles.add(a1);
    }
    public void afficherClient(){
        System.out.println(String.format("Bonjour %s, numero %d !", this.name, this.identifier));
        
        //afficher uniquement le premier article
        //listArticles.get(0).afficherArticle();
        // afficher tous les articles avec for i
        for (int i=0; i< listArticles.size();i++){
            listArticles.get(0).afficherArticle();
        }
        // afficher tous les articles avec for each
        for (Article a : listArticles){
            a.afficherArticle();
        }
    }
}

class TicketCaissePOO_re {

    public static void main(String[] args) {
        Client c1 = new Client("johnDoe", 2400);
        c1.afficherClient();
        c1.ajouterArticle(new Article("legumes", 1.99, 2.0));
    }
}