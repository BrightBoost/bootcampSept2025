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

        Dog dog2 = new Dog();
        dog2.setName("Lacey");
        dog2.setColour("black");
        dog2.setHeight(70);
        dog2.setLength(92);
        dog2.setEyeColour("black");
        dog2.setListenRatio(0.01);

        dog2.command("come here", false);

        System.out.println(dog1.speciesName);
        System.out.println(dog2.speciesName);
        System.out.println(Dog.speciesName);

        Dog dog3 = new Dog("rocky", "black", "brown", 20, 35, 0.7);
        dog3.command("pass");

    }
}
