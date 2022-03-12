/*

Sofia Pareja

Unit 4 - School Project

*/
public class Main {
    public static void main(String[] args) {

        School mySchool = new School("Everville", 1974, "Maple Ridge");

        // creating 10 students.The student number will be automatically generated.

        mySchool.addStudent("Tracy", "Allens", 10);
        mySchool.addStudent("Bob", "Lennon", 9);
        mySchool.addStudent("Allie", "Lennox", 9);
        mySchool.addStudent("Maxi" ,"Grace", 10);
        mySchool.addStudent("Rita", "Sanders", 11);
        mySchool.addStudent("Amanda" ,"Perez", 11);
        mySchool.addStudent("George" ,"Liu", 12);
        mySchool.addStudent("Lucas", "Zumaran",10);
        mySchool.addStudent("Matthew", "Jain", 11);
        mySchool.addStudent("Shelly", "Graces",12);


       // creating 3 teachers
        mySchool.addTeacher("Maria", "Ibanez", "Spanish");
        mySchool.addTeacher("Alvaro", "Chavez", "Math");
        mySchool.addTeacher("Joel", "Smith", "English");

        System.out.println("\n Original List of Students: ");
        System.out.println("---------------------------");
        mySchool.showStudents();
        System.out.println("\n Original List of Teachers: ");
        System.out.println("---------------------------");
        mySchool.showTeachers();


        System.out.println("\nRemoving 2 students. ");
        // removing Max Grace, whose student number is 4
        mySchool.removeStudent(4);

        //removing Shelly Graces, whose student number is 10
        mySchool.removeStudent(10);

        System.out.println("Removing 1 teacher. ");
        mySchool.removeTeacher("Joe", "Smith", "English");

        System.out.println("\n New List of Students: ");
        System.out.println("----------------------");
        mySchool.showStudents();
        System.out.println("\nNew List of Teachers: ");
        System.out.println("---------------------");
        mySchool.showTeachers();


    }
}
