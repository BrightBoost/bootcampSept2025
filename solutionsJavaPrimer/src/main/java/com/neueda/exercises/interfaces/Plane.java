package com.neueda.exercises.interfaces;

public class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("take off!");
    }

    @Override
    public void land() {
        System.out.println("Ryan air says: tuutuututuuu");
    }
}
