
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

    public static ArrayList<Student> getStudentsList() {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Person person : persons) {
            if (person.getClass().getSimpleName().equals("Student")) {
                students.add((Student) person);
            }
        }
        return students;
    }

    public static ArrayList<Teacher> getTeachersList() {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        for (Person person : persons) {
            if (person.getClass().getSimpleName().equals("Teacher")) {
                teachers.add((Teacher) person);
            }
        }
        return teachers;
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
    protected Grade grade;

    // constructeur
    public Teacher(String name, Double salary, String lesson, Grade grade) {
        super(name, salary);
        this.lesson = lesson;
        this.grade = grade;
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
    ArrayList<Mark> marks = new ArrayList<>();
    protected Grade grade;

    // constructeur
    public Student(String name, Grade grade) {
        super(name);
        this.grade = grade;
    }

    public void whoAmI() {
        super.whoAmI();
        System.out.println(String.format("je suis élève"));
    }

    public String toString() {
        return (String) this.name;
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    public ArrayList<Double> getAllMarks() {
        ArrayList<Double> allMarks = new ArrayList<>();
        for (Mark m : marks) {
            allMarks.add(m.number);
        }
        return allMarks;
    }

    public Double getAverage() {
        ArrayList<Double> allMarks = this.getAllMarks();
        Double total = 0.00;
        for (Double number : allMarks) {
            total += number;
        }
        return Double.isNaN((total / marks.size())) ? 0.0 : total / marks.size();
    }
}

class Grade {
    protected String name;
    // ArrayList<Person> persons = new ArrayList<>();

    // static Integer gradeCount = 0;
    public Grade(String name) {
        this.name = name;
        // gradeCount++;
    }

    public void getPersonsByGrade() {
        System.out.println(String.format("le professeur de la classe %s :", this.name));
        for (Teacher teacher : School.getTeachersList()) {
            if (this.name.equals(teacher.grade.name)) { // PB: ne peut pas recuperer le grade de Student, car person ne
                                                        // contient pas la variable "grade"
                teacher.whoAmI();
            }
        }
        System.out.println(String.format("les eleves de la classe %s :", this.name));
        for (Student student : School.getStudentsList()) {
            if (this.name.equals(student.grade.name)) { // PB: ne peut pas recuperer le grade de Student, car person ne
                                                        // contient pas la variable "grade"
                student.whoAmI();
            }
        }
    }

}

class Mark {
    Double number;

    // constructeur
    public Mark(Double number) {
        this.number = number;
    }
}

class POOSchool {
    public static void main(String[] args) {

        Grade grade1 = new Grade("5eB");
        School school1 = new School("Collège Sainte-Marie");
        school1.addPerson(new Student("Louis", grade1));
        school1.addPerson(new Principal("Gérard", 1600.00));
        school1.addPerson(new Teacher("Mme Lecoq", 1600.00, "SVT", grade1));
        school1.addPerson(new Kitchen("Roger"));
        school1.addPerson(new Cleaning("Jacques"));
        school1.addPerson(new Student("Jean", new Grade("6eB")));

        /*
         * school1.ringBell();
         * 
         * Person person = school1.getPersonByName("Louis");
         * person.whoAmI();
         */
        // add notes to student, and return mean + all notes
        Student student1 = new Student("Paul", grade1);
        student1.addMark(new Mark(15.00));
        student1.addMark(new Mark(16.50));
        student1.addMark(new Mark(14.00));
        student1.addMark(new Mark(12.50));
        System.out.println(student1.getAverage());
        System.out.println(student1.getAllMarks());
        // ajouter cet etudiant
        school1.addPerson(student1);

        // get grades of grade "5eb":
        grade1.getPersonsByGrade();
    }
}