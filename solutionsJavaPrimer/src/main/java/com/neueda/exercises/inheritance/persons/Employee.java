package com.neueda.exercises.inheritance.persons;

public class Employee extends Person {
    private String employeeID;
    // real life: DO NOT USE double for monetary values
    private double salary;

    public void displayEmployeeInfo() {
        displayPersonInfo();
        System.out.println("EmployeeID: " + employeeID + " - Salary " + salary);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
