import testLib.*;
class LibTestOne {
    public static void main(String[] args) {
        System.out.println("es tu la classe A ?");
        ClassA a= new ClassA();
        a.test();
        System.out.println("et toi?");
        ClassB b= new ClassB();
        b.test();
    }
}