package com.example.friendsbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    private String name;
    private String school;
    private int grade;
    private String email;

    Friend (String name,int grade,String school, String email){
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.email = email;


    }


    public String toString(){
        return name + " from " + school + " Grade: " +grade  +" Email: " + email;
    }

    public void writeToFile2(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + "," + grade + "," + school + "," + email +  "\r" );
        bw.close();
    }
    public void writeToFile1(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + "," + grade + "," + school + "," + email +  "\r" );
        bw.close();
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
