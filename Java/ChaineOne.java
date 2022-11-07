class ChaineOne {

    public static void CenterString( String fond, String titre)
    {
        int largeurFond = fond.length();
        int largeurTitre = titre.length();
        int larDebutFond = (largeurFond - largeurTitre)/2;
        String debutFond = fond.substring(0, larDebutFond);
        String finFond = fond.substring(larDebutFond+largeurTitre, largeurFond);
        System.out.println(debutFond+titre+finFond);
    }

    public static void main(String[] args)
    {
        CenterString("+------------+", "bonjour");
    }
}

