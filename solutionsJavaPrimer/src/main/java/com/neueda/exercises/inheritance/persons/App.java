package com.neueda.exercises.inheritance.persons;

public class App {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setTeamSize(10);
        manager.setName("Tom");
        manager.setAddress("Somewhere in London");
        manager.setEmployeeID("Company123");
        manager.setSalary(2000);

        manager.displayManagerInfo();
    }
}
