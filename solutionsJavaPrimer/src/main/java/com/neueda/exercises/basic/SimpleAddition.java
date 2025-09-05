package com.neueda.exercises.basic;

import java.util.Scanner;

public class SimpleAddition {
    //2. **Simple Addition**
    //   Write a program that prompts the user for two integer variables. Then, the program should add these two variables together and print out the result.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name a number:");
        int x = scanner.nextInt();
        System.out.println("Name a number:");
        int y = scanner.nextInt();
        int result = x + y;
        System.out.println("Result: " + result);
    }
}
