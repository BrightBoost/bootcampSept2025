package com.neueda.exercises.inheritance.animals;


//1. **Animal and Dog Class**
//        Create a superclass `Animal` with properties like `name`, `age`, and `weight`, and methods such as `eat()` and `sleep()`. Then create a subclass `Dog` that inherits from `Animal` and includes additional properties like `breed`, and methods such as `bark()`. Create several Dog objects in your main method and call various methods on them.


public class Animal {
    private String name;
    private int age;
    private double weight;

    public void eat() {
        System.out.println("Animal eating");
    }

    public void sleep() {
        System.out.println("Animal Zzzzz");
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
