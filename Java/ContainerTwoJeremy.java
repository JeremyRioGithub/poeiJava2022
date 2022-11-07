class ContainerTwoJeremy {

        public static void checkPrenom(String prenom) {
                if (prenom == "toto")
                        System.out.println("Toto ne va " + "jamais".toUpperCase() + " a l'ecole !");
                else 
                        System.out.println(String.format("A la difference de Toto, %s va " + "toujours".toUpperCase() + " a l'ecole !",prenom));
        }

        public static void main(String[] args) {
                String nom = "Toto";
                nom = nom.toLowerCase();
                int age = 16;
                checkPrenom(nom);
                if (age < 18) {
                        if ((age < 16) && (!nom.equals("toto"))) {
                                System.out.println(String.format("%s va a la petite ecole", nom));
                        }
                        System.out.println(String.format("%s est mineur", nom));
                } else
                        System.out.println(String.format("%s est majeur", nom));
                if (nom=="toto" ^ age <17)
                        System.out.println("soit toto, soit age <17    : "+nom+","+age);

                for (int i=0;i<10;i++){
                        System.out.println(i%3);
                }
                int v1 = 12;
                int v2 = 10;
                System.out.println(String.format("%s & %s = %s",Integer.toBinaryString(v1),Integer.toBinaryString(v2), Integer.toBinaryString(v1 & v2) ));
                System.out.println(String.format("%s | %s = %s",Integer.toBinaryString(v1),Integer.toBinaryString(v2), Integer.toBinaryString(v1 | v2) ));
                System.out.println(String.format("%s ^ %s = %s",Integer.toBinaryString(v1),Integer.toBinaryString(v2), Integer.toBinaryString(v1 ^ v2) ));

                
        }
}