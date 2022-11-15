package annonces;

import java.sql.*;
//import annonces.*;

public class AppelSQL {

    public AppelSQL() throws SQLException {
    }

    public void destructor() {
    }

    public void write(String requete) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leboncoin", "root", "Pa55w.rd");
            Statement stmt = con.createStatement();
            // Ajouter une ligne dans la table
            stmt.executeUpdate(requete);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet read(String requete) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leboncoin", "root", "Pa55w.rd");
            Statement stmt = con.createStatement();
            // Lire la table
            ResultSet rs = stmt.executeQuery(requete);
            System.out.println("id \ttype \ttitre \tprix \tdescription");
            while (rs.next())
                System.out.println(rs.getInt("id") + " \t" +
                        rs.getString("type") + " \t" +
                        rs.getString("titre") + " \t" +
                        rs.getString("prix") + " \t" +
                        rs.getString("description") + " \t" +
                        rs.getString("essence") + " \t" +
                        rs.getString("surface"));
            con.close();
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
