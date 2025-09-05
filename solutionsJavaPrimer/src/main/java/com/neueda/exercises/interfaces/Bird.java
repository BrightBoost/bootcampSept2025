package com.neueda.exercises.interfaces;

public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("gracefully flying bird");
    }

    @Override
    public void land() {
        System.out.println("landing in a tree");
    }
}
