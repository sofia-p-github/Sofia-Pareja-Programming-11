import java.util.ArrayList;

public class School {

    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> courses = new ArrayList<>();

    private String schoolName;
    private int yearFounded;
    private String schoolLocation;

    School(String schoolName, int yearFounded, String schoolLocation){
        this.schoolName = schoolName;
        this.yearFounded = yearFounded;
        this.schoolLocation = schoolLocation;
    }

        // This method  adds a student to the list of students
    public ArrayList addStudent(String firstName, String lastName, int grade){
        Student Student1 = new Student(firstName,lastName, grade);
        students.add(Student1);
        return students;
    }

    // This method adds a teacher to the list of teachers
    public ArrayList addTeacher(String firstName, String lastName, String subject){
        Teacher Teacher1 = new Teacher(firstName, lastName, subject);
        teachers.add(Teacher1);
        return teachers;
    }

    // This method removes a teacher from the list of teachers
    public ArrayList removeTeacher(String firstName, String lastName, String subject){
        for (int i = 0; i < teachers.size(); i++){
            if ((teachers.get(i).getFirstName() == firstName)&&(teachers.get(i).getLastName() == lastName)&&(teachers.get(i).getSubject() == subject)){
                teachers.remove(i);
            }
        }
        return teachers;
    }

    // This method removes a student from the list of students
    public ArrayList removeStudent(int studentNumber){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getStudentNumber() == studentNumber){
                students.remove(i);
            }
        }
        return students;
    }

    // This method shows all of the students in the list of students.
    public void showStudents(){
        for (int i = 0; i <students.size(); i++){
            System.out.println(students.get(i));
        }
    }

    // This method shows all of the teachers in the list of teachers.
    public void showTeachers(){
        for (int i = 0; i <teachers.size(); i++){
            System.out.println(teachers.get(i));
        }
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

}
