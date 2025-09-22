package com.neueda.classes;

public class Dog {
    private String name;
    private double weight;
    private String breed;
    private int nrOfLegs;
    private boolean bitesBurglars;
    private Owner owner;

    public Dog(String name, double weight, String breed, int nrOfLegs, boolean bitesBurglars, Owner owner) {
        this.name = name;
        this.weight = weight;
        this.breed = breed;
        this.nrOfLegs = nrOfLegs;
        this.bitesBurglars = bitesBurglars;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getNrOfLegs() {
        return nrOfLegs;
    }

    public void setNrOfLegs(int nrOfLegs) {
        this.nrOfLegs = nrOfLegs;
    }

    public boolean isBitesBurglars() {
        return bitesBurglars;
    }

    public void setBitesBurglars(boolean bitesBurglars) {
        this.bitesBurglars = bitesBurglars;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDetails() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", breed='" + breed + '\'' +
                ", nrOfLegs=" + nrOfLegs +
                ", bitesBurglars=" + bitesBurglars +
                ", owner='" + owner + '\'' +
                '}';
    }
}
