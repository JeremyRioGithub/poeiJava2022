class ChaineFormat {
    public static String writeBill(String label, String qte, String price, int spaceString, int spaceInt, int spaceFloat)
    {
        double priceD=Double.parseDouble(price); 
        int qteI=Integer.parseInt(qte); 
        double sumD = priceD*qteI;
        double PTTC = sumD*1.2;
        String resultat = String.format("|%-"+spaceString+"s\t|%"+spaceInt+"d\t|%"+spaceFloat+".2f\t|%"+spaceFloat+".2f\t|%"+spaceFloat+".2f\t", label, qteI, priceD, sumD, PTTC);
        return resultat;
    }
    
    public static void main(String[] args)
    {
        int spaceString = 8; // minimum 8
        int spaceFloat = spaceString-4;
        int spaceInt = spaceFloat-3;
        String header = String.format("|%-"+spaceString+"s\t|%-"+spaceInt+"s\t|%-"+spaceFloat+"s\t|%-"+spaceFloat+"s\t|%-"+spaceFloat+"s\t", "label","qte", "PU", "PT", "PTTC");
        System.out.println(header);
        System.out.println(writeBill("la boite", "2", "3.995", spaceString, spaceInt, spaceFloat));
        System.out.println(writeBill("camembert", "100", "6.554", spaceString, spaceInt, spaceFloat));

        String articles[] = { "pata", "tomat", "oignon", "radi", "salade", "chat", "prout", "clavier", "jasmin", "rose", "oeillet", "coupon"};
        Double prixs[] = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0};

        for (int i=0; i<articles.length; i++)
        {
            System.out.print(String.format("article n°%2d -> %10s %,.2f", i+1, articles[i], prixs[i]));
        }
        System.out.println("___ il faut payer maintenant !");



    }
}

