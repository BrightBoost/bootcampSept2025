package com.neueda.sample.newfeatures;

record Employee(int id, String name,double salary){}
public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1= new Employee(1,"Sonam",3456);
        Employee e2= new Employee(2,"Alexa",345699);

        System.out.println(e1);
        System.out.println("Name: "+e1.name());
        System.out.println("Salary "+e1.salary());
    }
}
