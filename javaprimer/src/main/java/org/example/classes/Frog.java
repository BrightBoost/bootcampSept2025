package org.example.classes;

public class Frog extends Pet {
    private double jumpingDistance;

    public Frog() {
    }

    @Override
    public void eat(String food) {
        System.out.println("sticking tongue out and swallowing " + food);
    }

    public Frog(String name, String colour, String eyeColour, double height, double length, double jumpingDistance, boolean isHealthy) {
        super(name, colour, eyeColour, height, length, isHealthy);
        this.jumpingDistance = jumpingDistance;
    }

    public double getJumpingDistance() {
        return jumpingDistance;
    }

    public void setJumpingDistance(double jumpingDistance) {
        this.jumpingDistance = jumpingDistance;
    }

    @Override
    public void breathe() {
        System.out.println("frog breathing");
    }
}
