import annonces.*;
class LibTestOne {
    public static void main(String[] args) {
        System.out.print("es tu la classe A ? : ");
        ClassBase base= new ClassBase();
        System.out.println(base);

        System.out.print("et toi ? : ");
        ClassVoiture voiture= new ClassVoiture();
        System.out.println(voiture);

        System.out.print("classA parle pour classe C : ");
        ClassMaison maison= new ClassMaison();
        System.out.println(maison);
    }
}