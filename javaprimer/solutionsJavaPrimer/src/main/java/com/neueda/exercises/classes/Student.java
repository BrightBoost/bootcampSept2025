package com.neueda.exercises.classes;

public class Student {
    //2. **Student Class**
    //   Create a `Student` class with properties `name`, `age`, `grade` and `major`. Include a constructor and a method called `displayStudentInfo()` that prints all of the information about the student. In your main method, create several Student objects and call `displayStudentInfo()` on them.
    private String name;
    private int age;
    private char grade;
    private String major;

    public Student(String name, int age, char grade, String major) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void displayStudentInfo() {
        String student = "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                '}';
        System.out.println(student);
    }
}

