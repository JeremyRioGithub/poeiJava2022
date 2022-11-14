import java.util.Scanner;
import java.sql.*; 
import annonces.*;

class LeBonCoin {
    static Scanner sc1 = new Scanner(System.in);
    public static void main(String[] args) {
        // Sans la saisie :
        System.out.print("annonce de Base : \t");
        Annonce base1= new Annonce("pasCher", "55", "chaussetteUsagees");
        System.out.print(base1 + "\t");
        base1.afficher();

        // Sans la saisie :
        System.out.print("annonce type Voiture : \t");
        AnnonceVoiture voiture= new AnnonceVoiture("fiote500", "3500", "en l'état", "essence");
        System.out.print(voiture + "\t");
        voiture.afficher();

        // Sans la saisie :
        System.out.print("annonce type Maison : \t");
        AnnonceMaison maison= new AnnonceMaison("chaumiere", "55000", "a renover", "100m2");
        System.out.print(maison + "\t");
        maison.afficher();

        System.out.println("nouvelle Annonce: \t");
        Annonce a=new Annonce();
        Annonce b=new Annonce();
        String annonce=sc1.nextLine();
        if (annonce.equals("voiture")){
            a=new AnnonceVoiture();
            b=new AnnonceVoiture();
        }
        else if (annonce.equals("maison")){
            a=new AnnonceMaison();
            b=new AnnonceMaison();
        }
        a.saisie(sc1);
        //System.out.println(a + "\t");
        //a.afficher();
        a.save();

/* 
DROP DATABASE leboncoin;
CREATE DATABASE leboncoin;
USE leboncoin;
CREATE TABLE annonce (
	type VARCHAR(255),
	titre VARCHAR(255),
	prix VARCHAR(255),
	description VARCHAR(255)
); 
*/
        
        b.load(1);
        //System.out.println(b);


        
        try
        {  
            Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/leboncoin","root","Pa55w.rd");  
            Statement stmt=con.createStatement();  

            // Ajouter une ligne dans la table
            //stmt.executeUpdate("INSERT INTO annonce (titre, prix, description) VALUES ('boy', '150.0', 'dd');");
            stmt.executeUpdate(a.save());

            // Lire la table
            ResultSet rs=stmt.executeQuery("select * from annonce;");  
            System.out.println("id \ttype \ttitre \tprix \tdescription");
            while(rs.next())  
                System.out.println(rs.getInt("id")+" \t"+
                rs.getString("type")+" \t"+
                rs.getString("titre")+" \t"+
                rs.getString("prix")+" \t"+
                rs.getString("description"));  
            con.close(); 
        }
        catch(Exception e)
        { 
            System.out .println(e);
        }  



        sc1.close();
    }
}