class LoopAlgo{

    public static void main(String[] args){
        System.out.println("HelloW");

        for (int i=0; i<5; i++)
        {
            for (int j=0; j<15; j++)
                System.out.print("0");
            System.out.println(" : " +i);

        }

        System.out.println("----------------------------");

        for (int i=0; i<5; i++)
        {
            if (i==0){
                for (int j=0; j<15; j++)
                    System.out.print((j)+":"+ "\t");
                System.out.println("");
            }
            for (int j=0; j<15; j++)
                System.out.print((j*i)+ "\t");
            System.out.println(" : " +i);
        }

        
        System.out.println("----------------------------");

        int compteurStar=0;
        for (int i=0;i<10;i++)
        {
            for (int j=0; j<=i; j++)
                {
                    compteurStar++;
                    System.out.print("*");
                }
            System.out.print(compteurStar);
            System.out.println("");
        }
        System.out.println(compteurStar);
    }
}