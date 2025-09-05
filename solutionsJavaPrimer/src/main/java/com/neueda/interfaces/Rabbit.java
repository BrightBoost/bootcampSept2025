package com.neueda.interfaces;

public class Rabbit extends Animal implements Prey {

    @Override
    public void run() {
        System.out.println("rabbit hopping away");
    }

    @Override
    public void hide() {
        System.out.println("down the rabbit hole");
    }
}
