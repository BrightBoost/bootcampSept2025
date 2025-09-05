package org.example.classes;

public class App {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setName("Cliff");
        dog1.setColour("Red");
        dog1.setHeight(40);
        dog1.setLength(50);
        dog1.setEyeColour("dark brown");
        dog1.setListenRatio(0.5);

        dog1.command("come here");
    }
}
