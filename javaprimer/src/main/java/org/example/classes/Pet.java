package org.example.classes;

public abstract class Pet {
    private String name;
    private String colour;
    private String eyeColour;
    private double height;
    private double length;
    private boolean isHealthy;

    public Pet() {
    }

    public Pet(String name, String colour, String eyeColour, double height, double length, boolean isHealthy) {
        this.name = name;
        this.colour = colour;
        this.eyeColour = eyeColour;
        this.height = height;
        this.length = length;
        this.isHealthy = isHealthy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public abstract void eat(String food);

    public void breathe() {
        System.out.println("regular breathing for pet");
    }
}
