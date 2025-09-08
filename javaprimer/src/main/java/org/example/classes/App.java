package org.example.classes;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Dog dog1 = new Dog();
        dog1.setName("Cliff");
        dog1.setColour("Red");
        dog1.setHeight(40);
        dog1.setLength(50);
        dog1.setEyeColour("dark brown");
        dog1.setListenRatio(0.5);
        dog1.setHealthy(true);

        dog1.command("come here");

        Dog dog2 = new Dog();
        dog2.setName("Lacey");
        dog2.setColour("black");
        dog2.setHeight(70);
        dog2.setLength(92);
        dog2.setEyeColour("black");
        dog2.setListenRatio(0.01);
        dog2.setHealthy(true);

        dog2.command("come here", false);

        System.out.println(dog1.speciesName);
        System.out.println(dog2.speciesName);
        System.out.println(Dog.speciesName);

        Dog dog3 = new Dog("rocky", "black", "brown", 20, 35, 0.7, true);
        dog3.command("pass");
        dog3.breathe();

        // polymorphism - assign child instance to parent type
        Pet pet1 = new Frog("kermit", "green", "black", 5, 5, 200, true);
        pet1.breathe();
        ((Frog) pet1).getJumpingDistance();

        Frog frog2 = new Frog("quak", "green", "black", 5, 5, 200, true);

        List<Pet> pets = List.of(dog1, dog2, dog3, pet1, frog2);

        for(Pet p : pets) {
            if(p instanceof Dog d) {
                d.command("blabla", true);
            } else if(p instanceof Frog f) {
                f.setJumpingDistance(200);
            }
        }


    }
}
