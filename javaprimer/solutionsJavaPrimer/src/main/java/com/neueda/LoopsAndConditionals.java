package com.neueda;

import java.util.ArrayList;
import java.util.List;

public class LoopsAndConditionals {
    public static void main(String[] args) {
        // if statements
        int x = 19;
        if(x == 8) {
            System.out.println("x is equal to 8!");
        } else {
            System.out.println("x is not equal to 8.");
        }

        if(x < 10) {
            System.out.println("x is smaller than 10");
        } else if(x > 10) {
            System.out.println("x is bigger than 10");
        } else if(x == 10) {
            System.out.println("x is equal to 10");
        } else {
            System.out.println("this should never happen");
        }

        String language = "Java";

        if(language.equals("Java")) {
            System.out.println("great choice!");
        } else if(language.equals("Python")) {
            System.out.println("alright, great choice too");
        } else if(language.equals("JavaScript")) {
            System.out.println("are you sure?");
        } else if(language.equals("Rust")) {
            System.out.println("I hope you know what you're doing");
        } else if(language.equals("C#")) {
            System.out.println("Java knockoff");
        } else {
            System.out.println("Language doesn't matter, programming is great!");
        }

        switch(language) {
            case "Java":
                System.out.println("Great choice!");
                break;
            case "Python":
                System.out.println("Great choice too");
                break;
            case "JavaScript":
                System.out.println("Are you sure");
                break;
            default:
                System.out.println("Language doesn't matter, programming is great!");
                break;
        }


        // for loop - repeat something a certain nr of times
        for(int i = 0; i < 12; i++) {
            System.out.println("i: " + i);
        }

        List<String> names = new ArrayList<>();
        names.add("Aruna");
        names.add("Rashi");
        names.add("Sudharsan");

        for(int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // while loop - repeat as long as a certain condition is true
        int i = 0;
        while(i < 10) {
            System.out.println("while i: " + i);
            i++;
        }

        // foreach loop - looping over a multiple elements
        for(String name : names) {
            System.out.println(name);
        }

    }
}
