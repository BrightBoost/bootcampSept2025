package com.neueda.exercises.inheritance.persons;

public class Manager extends Employee {
    private int teamSize;

    public void displayManagerInfo() {
        displayEmployeeInfo();
        System.out.println("Teamsize: " + teamSize);
    }
    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
