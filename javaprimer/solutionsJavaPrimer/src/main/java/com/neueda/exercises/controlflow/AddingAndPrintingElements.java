package com.neueda.exercises.controlflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingAndPrintingElements {
//    1. **Adding and Printing Elements**
//    Write a program that creates a List of Strings. Ask the user for 5 names, add them to the list, and then print out each name on a new line.
//
public static void main(String[] args) {
    // create list
    List<String> names = new ArrayList<>();

    // ask for input
    Scanner scanner = new Scanner(System.in);
    for(int i = 0; i < 5; i++) {
        System.out.println("Please enter a name:");
        String name = scanner.nextLine();
        names.add(name);
    }

    // print all
    System.out.println(names);

    // print
    for(String name: names) {
        System.out.println(name);
    }
}

}
