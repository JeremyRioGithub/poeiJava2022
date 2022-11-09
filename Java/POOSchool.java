import java.util.ArrayList;

class Person {
    String description = "je fais partie de l'école";
    String name = "inconnu";

    public Person(String namePerson) {
        this.name = namePerson;
    }

    public void whoAmI() {
        System.out.print(String.format("%s, %s", this.name, this.description));
    }
}

class Employee extends Person {
    String description = ", je suis employé";

    // Integer salary=1000;
    public Employee(String name) {
        super(name);
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print(String.format("%s", this.description));
    }
}

class Principal extends Employee {
    String description = " et je suis responsable de l'etablissement et de ses employés";

    public Principal(String name) {
        super(name);
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print(String.format("%s", this.description));
    }
}

class Teacher extends Employee {
    String description = " et je donne des lecons";
    String lesson = "first lesson";

    public Teacher(String name, String lesson) {
        super(name);
        this.lesson = lesson;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print(String.format("%s", this.description));
    }
}

class Volunteer extends Person {
    String description = ", je suis volontaire";

    public Volunteer(String name) {
        super(name);
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print(String.format("%s", this.description));
    }
}

class Kitchen extends Volunteer {
    String description = " et je fait la cuisine";

    public Kitchen(String name) {
        super(name);
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print(String.format("%s", this.description));
    }
}

class Cleaning extends Volunteer {
    String description = " et je nettoie les salles";

    public Cleaning(String name) {
        super(name);
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print(String.format("%s", this.description));
    }
}

class Student extends Person {
    String description = " et je vais à des cours à l'école";
    String grade = "";

    public Student(String name, String grade) {
        super(name);
        this.grade = grade;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print(String.format("%s", this.description));
    }
}

class School {
    ArrayList<Person> persons = new ArrayList<Person>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void ringBell() {
        for (Person person : persons) {
            person.whoAmI();
            System.out.println("");
        }
    }

    public Person getPersonByName(String name) {
        for (Person person : persons) {
            if (person.name.equals(name)) {
                System.out.println("");
                person.whoAmI();
                System.out.println("");
                return person;
            }
        }
        return null;
    }
}

public class POOSchool {
    public static void main(String[] args) {
        Person pe1 = new Person("Person-1");
        Employee em1 = new Employee("Employee-1");
        Principal pr1 = new Principal("Principal-1");
        Teacher t1 = new Teacher("Gabrielle Russier", "arts");
        Volunteer v1 = new Volunteer("Volunteer-1");
        Kitchen k1 = new Kitchen("Kitchen-1");
        Cleaning c1 = new Cleaning("Cleaning-1");
        Student s1 = new Student("Maddie Ziegler", "primary");

        School sc1 = new School();
        sc1.addPerson(pe1);
        sc1.addPerson(em1);
        sc1.addPerson(pr1);
        sc1.addPerson(t1);
        sc1.addPerson(v1);
        sc1.addPerson(k1);
        sc1.addPerson(c1);
        sc1.addPerson(s1);
        (new School()).addPerson(s1);

        sc1.ringBell(); // ringbell returns the description of each person of the school

        Person person = sc1.getPersonByName("Gabrielle Russier"); // renames Person name = "Gabrielle Russier"
        // je renomme person (qui correspond à la base à "Gabrielle Russier")
        person.name = "Gabriel R.";
        // je check qui est person
        person.whoAmI();

        // je renomme t1 (qui correspond aussi à la base à "Gabrielle Russier")
        t1.name = "G. R.";
        // je check qui sont person et t1, et je peux voir leur noms respectifs. (ils
        // montrent le meme nom puisque person et t1 pointent vers la meme personne qui
        // était à l'origine "Gabrielle Russier" et qui s'appelle maintenant "G. R.")
        person.whoAmI();
        t1.whoAmI();

    }
}
