package com.neueda.exercises.classes;

public class App {
    public static void main(String[] args) {
        Book book = new Book("Spring Boot and Angular", "Devlin and Selji", 300);
        book.printInfo();
        Student student = new Student("Chenxin", 20, 'A', "Software development");
        student.displayStudentInfo();

        Microphone microphone = new Microphone();
        microphone.setBrand("d");
        System.out.println(microphone.getBrand());
        microphone.brand2 = "Rode";

    }
}
