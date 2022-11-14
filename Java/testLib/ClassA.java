package testLib;

public class ClassA {
    public ClassA () {}
    public String toString() {
        return "'en effet, je suis la classe A'";
    }
    public void parlerPourClass(String texteDeClass) {
        System.out.print("classA parle pour une autre classe : "+ texteDeClass);
        System.out.println();
    }
}
