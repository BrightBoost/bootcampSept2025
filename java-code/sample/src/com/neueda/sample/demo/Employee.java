package com.neueda.sample.demo;

public class Employee {
    private int id;
    private String name;
    private String department_name;
    private double salary;

    public Employee(){}

    public Employee(String name, String department_name, double salary) {
//        this.id= Math.abs((int) Math.random()*1000));
        this.name = name;
        this.department_name = department_name;
        this.salary = salary;
    }

    public Employee(int id, String name, String department_name, double salary) {
        this.id = id;
        this.name = name;
        this.department_name = department_name;
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

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
