package org.example.classes;

public class Dog {
    public static final String speciesName = "Canis lupus familiaris";
    private String name;
    private String colour;
    private String eyeColour;
    private double height;
    private double length;
    private double listenRatio;

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

    public double getListenRatio() {
        return listenRatio;
    }

    public void setListenRatio(double listenRatio) {
        this.listenRatio = listenRatio;
    }

    public boolean command(String instruction) {
        System.out.println(name + ", " + instruction);
        if(listenRatio * Math.random() > 0.1) {
            System.out.println(name + " listens");
            return true;
        } else {
            System.out.println(name + " seems to ignore you.");
            return false;
        }
    }

}
