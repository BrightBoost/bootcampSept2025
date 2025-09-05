package org.example.classes;

public class Dog extends Pet {
    public static final String speciesName = "Canis lupus familiaris";
    private double listenRatio;

    public Dog() {
    }

    public Dog(String name, String colour, String eyeColour, double height, double length, double listenRatio, boolean isHealthy) {
        super(name, colour, eyeColour, height, length, isHealthy);
        this.listenRatio = listenRatio;
    }

    public double getListenRatio() {
        return listenRatio;
    }

    public void setListenRatio(double listenRatio) {
        this.listenRatio = listenRatio;
    }

    public boolean command(String instruction, boolean urgent) {
        System.out.println(getName() + ", " + instruction);
        if(listenRatio * Math.random() > 0.1 || urgent) {
            System.out.println(getName() + " listens");
            return true;
        } else {
            System.out.println(getName() + " seems to ignore you.");
            return false;
        }
    }

    public boolean command(String instruction) {
        System.out.println(getName() + ", " + instruction);
        if(listenRatio * Math.random() > 0.1) {
            System.out.println(getName() + " listens");
            return true;
        } else {
            System.out.println(getName() + " seems to ignore you.");
            return false;
        }
    }

    @Override
    public void eat(String food) {
        System.out.println(getName() + " ate " + food + ". Wait that was edible, right?");
    }

}
