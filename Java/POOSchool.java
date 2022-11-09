
// Ecole / personnes qui font partie de l'école / individu / salarié / bénévole à la cantine / élève / niveau / classe / cours
// directeur supérieur à salarié
// Faire un diagramme
// Faire les classes et les fonctions
// Quand on tape le nom de qqun : savoir qui c'est (quel travail, salaire, quelle classe, moyenne générale, notes par matière), pouvoir faire des modifs sur sa fiche
// Pouvoir changer la note d'un élève
// On sonne l'ouverture de l'école et tout le monde fait ce qu'il a à faire : regarder les menus, allumer les fours, faire l'appel, sortir les cahiers etc.
// Code From LucieR: https://github.com/lucierou/ExercicesJAVA/blob/main/POOSchool.java 221109 before 13:00.
import java.util.ArrayList;

class School {
    protected String name;
    public static ArrayList<Person> persons = new ArrayList<>();

    static Integer schoolsCount = 0;

    // constructeur
    public School(String name) {
        this.name = name;
        schoolsCount++;
    }

    public void ringBell() {
        System.out.println("****************************************************");
        System.out.println(String.format("L'école s'appelle %s", this.name));
        for (Person person : persons) {
            person.whoAmI();
        }
        System.out.println("****************************************************");
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person getPersonByName(String name) {
        for (Person person : persons) {
            if (person.name == name) {
                return person;
            }
        }
        return null;
    }
    
    public static ArrayList<Student> getStudentsList(){
        ArrayList<Student> students = new ArrayList<Student>();
        for (Person person : persons) {
            if (person.getClass().getSimpleName().equals("Student")) {
                students.add((Student)person);
            }
        }
        return students;
    }
    

}

class Person {
    protected String name;

    static Integer personsCount = 0;

    // constructeur
    public Person(String name) {
        this.name = name;
        personsCount++;
    }

    public void whoAmI() {
        System.out.print(String.format("Je m'appelle %s, ", this.name));
    }
}

class Employee extends Person {
    Double salary;
    static Integer employeesCount = 0;

    // constructeur
    public Employee(String name, Double salary) {
        super(name);
        this.salary = salary;
        employeesCount++;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print("je travaille dans l'école, ");
    }
}

class Principal extends Employee {
    static Integer principalsCount = 0;

    // constructeur
    public Principal(String name, Double salary) {
        super(name, salary);
        principalsCount++;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.println(String.format("je suis directeur et mon salaire est de %.2f euros", this.salary));
    }
}

class Teacher extends Employee {
    private String lesson;
    static Integer teachersCount = 0;

    // constructeur
    public Teacher(String name, Double salary, String lesson) {
        super(name, salary);
        this.lesson = lesson;
        teachersCount++;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.println(
                String.format("je suis professeur de %s et mon salaire est de %.2f euros", this.lesson, this.salary));
    }
}

class Volunteer extends Person {
    static Integer volunteersCount = 0;

    // constructeur
    public Volunteer(String name) {
        super(name);
        volunteersCount++;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.print("je suis bénévole ");
    }
}

class Cleaning extends Volunteer {
    static Integer cleaningsCount = 0;

    // constructeur
    public Cleaning(String name) {
        super(name);
        cleaningsCount++;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.println("pour le ménage");
    }
}

class Kitchen extends Volunteer {
    static Integer kitchensCount = 0;

    // constructeur
    public Kitchen(String name) {
        super(name);
        kitchensCount++;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.println("à la cantine");
    }
}

class Student extends Person {
    protected Grade grade;
    // constructeur
    public Student(String name, Grade grade) {
        super(name);
        this.grade=grade;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.println(String.format("je suis élève"));
    }

    public String toString() {
        return (String) this.name;
    }
}

class Grade {
    protected String name;
    //ArrayList<Person> persons = new ArrayList<>();

    // static Integer gradeCount = 0;
    public Grade(String name) {
        this.name = name;
        // gradeCount++;
    }

    public void getPersonsByGrade() {
        System.out.println(String.format("les eleves de la classe %s :", this.name));
        for (Student student : School.getStudentsList()) {
                if (this.name.equals(student.grade.name)){ // PB: ne peut pas recuperer le grade de Student, car person ne contient pas la variable "grade"
                    System.out.println("Student:");
                    student.whoAmI();
                }
        }
    }

}

class POOSchool {
    public static void main(String[] args) {

        Grade grade1 = new Grade("5eB");
        School school1 = new School("Collège Sainte-Marie");
        school1.addPerson(new Student("Louis", grade1));
        school1.addPerson(new Principal("Gérard", 1600.00));
        school1.addPerson(new Teacher("Mme Lecoq", 1600.00, "SVT"));
        school1.addPerson(new Kitchen("Roger"));
        school1.addPerson(new Cleaning("Jacques"));
        school1.addPerson(new Student("Jean", new Grade("6eB")));

        //school1.ringBell();

        //Person person = school1.getPersonByName("Louis");
        //person.whoAmI();

        grade1.getPersonsByGrade();
    }
}