import java.util.*;
//import java.util.ArrayList.*;

class ContainerOneJeremy {

// creation des list qui vont contenir les données
    static ArrayList<String> payss = new ArrayList<String>();

    public static void main(String[] args) {

        payss.add("italie");
        payss.add("monaco");
        payss.add("andorre");
        payss.add("vatican");
        payss.add("san marin");

//afficher la liste avec "for int i"
        for (int i=0;i<payss.size();i++)
            System.out.println(String.format("n°%d : %s",i+1,payss.get(i))  );
// ajouter et supprimer un element de la liste
        payss.add("malte");
        payss.add("italie");
        payss.remove("monaco");
// supprimer l'andorre en utilisant sa place dans la liste.
        int positionAndorre = payss.indexOf("andorre");
        payss.remove(positionAndorre);
// afficher la liste avec "for each"
        for (String pays : payss)
            System.out.println(pays);
// check si remove enleve un ou plusieurs occurences. J'ai deux italie, le(s)quel(s) est supprimé? la premiere occurence.
        payss.remove("italie");
    }
}