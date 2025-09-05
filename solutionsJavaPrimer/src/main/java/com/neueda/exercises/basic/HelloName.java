package com.neueda.exercises.basic;

import java.util.Scanner;

public class HelloName {
    //1. **Hello, Name!**
    //   Create a program that prompts the user for their name. Store this name in a String variable and print out a greeting message to the user.
    //
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what's your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
    }

}
