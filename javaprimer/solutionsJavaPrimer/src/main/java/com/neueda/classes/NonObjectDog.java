package com.neueda.classes;

import java.util.ArrayList;
import java.util.List;

public class NonObjectDog {
    public static void main(String[] args) {
        String name = "Bobby";
        double weight = 20;
        String breed = "Labradoodle";
        int nrOfLegs = 4;
        boolean bitesBurglars = false;
        List<String> skills = new ArrayList<>();
        skills.add("Be happy");
        String owner = "Maaike";

        String nameOfSeansDog = "Max";
        double weightOfSeansDog = 35;
        String breedOfSeansDog = "toypoodle";
        int nrOfLegsOfSeansDog = 4;
        boolean bitesBurglarsSeansDog = false;
        List<String> skillsOfSeansDog = new ArrayList<>();
        skillsOfSeansDog.add("Keeping Sean company on long forest walks");
        skillsOfSeansDog.add("Being super cute");
        String ownerOfSeansDog = "Sean";

        // print dogs
        System.out.println("Name: " + name + ". Weight: " + weight);
        System.out.println("Name: " + nameOfSeansDog + ". Weight: " + weightOfSeansDog);

    }
}
