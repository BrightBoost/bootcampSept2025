package com.neueda.inheritance;

public class Student extends Person {
    private String studentNr;

    public Student(String name, int age, String email, String studentNr) {
        super(name, age, email);
        this.studentNr = studentNr;
    }

    public String getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(String studentNr) {
        this.studentNr = studentNr;
    }
}
