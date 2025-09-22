package com.neueda.sample.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee e1= new Employee(1,"Maaike",10000);
        Employee e2= new Employee(2,"Sonam",20000);
        Employee e3= new Employee(3,"Alexa",30000);

        List<Employee> list= new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);


        // Filter Employees with salary >150000
        List<String> data=list.stream().filter(e->e.salary>15000).map(e->e.getName()).toList();
        System.out.println(data);
    }
}
