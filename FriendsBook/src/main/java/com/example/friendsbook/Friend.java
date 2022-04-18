package com.example.friendsbook;

public class Friend {
    private String name;
    private String school;
    private int grade;
    private String email;

    Friend (String name, String school, int grade,String email){
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.email = email;

    }

    public String toString(){
        return name + " from " + school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
