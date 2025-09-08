package com.neueda.exercises.inheritance.animals;

public class Dog extends Animal {
    private String breed;

    public void bark() {
        System.out.println("WOOF WOOF");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
