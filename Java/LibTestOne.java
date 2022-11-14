import testLib.*;
class LibTestOne {
    public static void main(String[] args) {
        System.out.print("es tu la classe A ? : ");
        ClassA a= new ClassA();
        //a.toString();
        System.out.println(a);

        System.out.print("et toi ? : ");
        ClassB b= new ClassB();
        //b.toString();
        System.out.println(b);

        System.out.print("classA parle pour classe C : ");
        ClassC c= new ClassC();
        a.parlerPourClass(c.toString());;
    }
}