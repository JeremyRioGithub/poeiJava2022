class JeremyBitsConfidenceCFD {

        public static void confidence(String octet)
        {
                System.out.println(octet); 
                long nbrDe1 = octet.chars().filter(ch -> ch == '1').count();
                long nbrDe0 = octet.chars().filter(ch -> ch == '0').count();
                System.out.println(String.format("n0=%d ,  n1=%d", nbrDe0, nbrDe1)); 
        }

        public static void main(String[] args) {
                int nombre = 253;
                String octet = Integer.toBinaryString(nombre);
                confidence(octet);
                int var = -256;
                System.out.println(String.format("avant: %d %s", var , Integer.toBinaryString(var)));
                var = var >> 8;
                System.out.println(String.format("apres: %d %s", var , Integer.toBinaryString(var)));
        }
        
}