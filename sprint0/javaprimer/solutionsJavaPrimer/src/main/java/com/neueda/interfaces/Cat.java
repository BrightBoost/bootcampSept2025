package com.neueda.interfaces;

public class Cat extends Animal implements Predator, Prey {

    @Override
    public void catchAnimal() {
        System.out.println("Cat is catching the poor prey!");
    }

    @Override
    public void eatAnimal() {
        System.out.println("Plays with the food an hour and then don't eat it at all!");

    }

    @Override
    public void run() {
        System.out.println("Cat is running home");
    }

    @Override
    public void hide() {
        System.out.println("Hide with the owner");
    }
}
