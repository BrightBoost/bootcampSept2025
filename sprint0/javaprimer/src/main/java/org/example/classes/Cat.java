package org.example.classes;

public class Cat extends Pet {
    public static final String speciesName = "Felis catus";

    public Cat() {
    }

    public Cat(String name, String colour, String eyeColour, double height, double length, boolean isHealthy) {
        super(name, colour, eyeColour, height, length, isHealthy);
    }

    @Override
    public void eat(String food) {
        System.out.println("after inspecting it carefully, " + getName() + " ate " + food);
    }


}
