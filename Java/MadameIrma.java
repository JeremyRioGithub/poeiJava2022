class  MadameIrma {
    // Jeremy d'apres Xavier

    public static int numeroDeLaChance(  String str )
    {
        int numeroSomme=0;
        str = str.toLowerCase();
        for( int i = 0 ; i < str.length() ; i++ )
        {
            char charactere = str.charAt( i );
            if ((charactere == 'é') || (charactere == 'è') || (charactere == 'ê') || (charactere == 'ë') ){
                charactere = 'e';
            }
            if ((charactere == 'É') || (charactere == 'è') || (charactere == 'ê') || (charactere == 'ë') ){
                charactere = 'E';
            }
            System.out.println(charactere);
            int valeur = charactere - (int)'a';
            numeroSomme += valeur;
            numeroSomme = numeroSomme%50;
        }
        int numeroChance = numeroSomme;

        return numeroChance;
    }  

    public static void main(String[] args) {

        String prenom = "Anne-Isabelle";
        int numDeChance = numeroDeLaChance( prenom ); 
        System.out.println( String.format( "le numéro de la chance de %s est %d", prenom, numDeChance ));
    }
}