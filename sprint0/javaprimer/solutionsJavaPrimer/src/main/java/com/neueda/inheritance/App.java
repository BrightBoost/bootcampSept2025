package com.neueda.inheritance;

public class App {
    public static void main(String[] args) {
        Student student = new Student("Nethra", 20, "n@citi.com", "1234");
        Person person = new Person("Anandamayee", 20, "a@citi.com");

        student.setName("Mengqi");
        student.setAge(20);
        student.setStudentNr("22342340");
        student.setEmail("m@university.com");

        // polymorphism = greek for many shapes
        Person s1 = new Student("Nethra", 20, "n@citi.com", "1234");
        Student s2 = new Student("Nethra", 20, "n@citi.com", "1234");

        if(s1 instanceof Student) {
            ((Student) s1).getStudentNr();
        }


        checkPersonOrStudent(student);
    }

    public static void checkPersonOrStudent(Person o) {

    }
}
