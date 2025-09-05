package com.neueda.exercises.controlflow;

import java.util.Scanner;

public class EvenOrOdd {
    //            3. **Even or Odd**
//    Write a program that asks the user for an integer and then prints whether the number is even or odd.
    public static void main(String[] args) {
        // ask for integer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a nr:");
        int nr = scanner.nextInt();

        // check for even or odd
        if(nr % 2 == 0) {
            System.out.println("It's even!");
        } else {
            System.out.println("It's odd!");
        }
    }
}
