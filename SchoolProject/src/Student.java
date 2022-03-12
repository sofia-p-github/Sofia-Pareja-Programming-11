public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private int studentNumber;
    static int totalStudents = 1;

    // constructor
    Student(String firstName, String lastName, int grade){
       this.firstName = firstName;
       this.lastName = lastName;
       this.grade = grade;
       this.studentNumber = totalStudents;
       totalStudents += 1;

    }

    // when a student object is printed, it will print out this
    public String toString(){
        return  "Name: " + this.firstName + " "+ this.lastName + "\t\t\t" + "Grade: " + this.grade ;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
