package com.neueda.exercises.classes;

public class Microphone {
    private String brand;
    // "default access" also knows as package private
    String  brand2;

    public String getBrand() {
        return brand;
    }


    // advantage of enccapsulation: validation
    public void setBrand(String brand) {
        if(brand.length() > 2) {
            this.brand = brand;
        }
    }
}
