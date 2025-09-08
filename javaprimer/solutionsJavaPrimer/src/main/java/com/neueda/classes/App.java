package com.neueda.classes;

public class App {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Maaike", 32);
        Dog maaikesDog = new Dog("bobby", 20, "labradoodle", 4, false, owner1);

        Owner owner2 = new Owner("Arne", 41);
        Dog arnesDog = new Dog("Maddy", 15, "tiny sheppard mix", 4, true, owner2);


        Owner owner3 = new Owner("Sean", 55);
        Dog seansDog = new Dog("Max", 4, "toy poodle", 4, true, owner3);


        System.out.println(seansDog.getDetails());
        System.out.println(arnesDog.getDetails());
        System.out.println(maaikesDog.getDetails());
    }


}
