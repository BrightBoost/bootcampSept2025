package com.neueda.exercises.controlflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindingLargestSmallestNumber {
    //2. **Finding the Largest and Smallest Number**
//    Write a program that creates a List of Integers. Ask the user for 10 numbers, add them to the list. Then, find and print out the smallest and largest number from the list.
//
    public static void main(String[] args) {
        // create list
        List<Integer> nrs = new ArrayList<>();

        // ask for input
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            System.out.println("Please enter a nr:");
            int nr = scanner.nextInt();
            nrs.add(nr);
        }

        // print all
        System.out.println(nrs);

        // find the largest and the smallest
        int smallest = nrs.get(0);
        int largest = nrs.get(0);

        for(int nr : nrs) {
            if(nr > largest) {
                largest = nr;
            }
            if(nr < smallest) {
                smallest = nr;
            }
        }

        // print
        System.out.println("The smallest is: " + smallest + ". The largest is: " + largest);
    }
}
