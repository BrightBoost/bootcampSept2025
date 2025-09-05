package com.neueda.interfaces;

public class Wolf extends Animal implements Predator {
    @Override
    public void catchAnimal() {
        System.out.println("catching the animal");
    }

    @Override
    public void eatAnimal() {
        System.out.println("wolf eating the animal");
    }
}
