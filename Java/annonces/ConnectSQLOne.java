package annonces;
import java.sql.*;  
//import java.util.*;
//import java.util.ArrayList.*;



/* 
javac ConnectSQLOne.java 

puur pouvoir être éxécuté le fichier mysql-connector-java-8.0.30.jar doit etre présent
le lancement se fait :
java -cp mysql-connector-java-8.0.30.jar ConnectSQLOne.java 
*/

class  ConnectSQLOne {
    // Xavier

    public static void main(String[] args) 
    {
        try
        {  
            Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/leboncoin","root","Pa55w.rd");  
            Statement stmt=con.createStatement();  

            // Ajouter une ligne dans la table
            //stmt.executeUpdate("INSERT INTO annonce (titre, prix, description) VALUES ('boy', '150.0', 'dd');");

            // Lire la table
            ResultSet rs=stmt.executeQuery("select * from annonce;");  
            System.out.println("id \ttype \ttitre \tprix \tdescription");
            while(rs.next())  
                System.out.println(rs.getInt(1)+" \t"+
                rs.getString(2)+" \t"+
                rs.getString(3)+" \t"+
                rs.getString(4)+" \t"+
                rs.getString(5));  
            con.close(); 
        }
        catch(Exception e)
        { 
            System.out .println(e);
        }  
    }

}