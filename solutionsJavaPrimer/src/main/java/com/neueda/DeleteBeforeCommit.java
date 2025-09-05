package com.neueda;

import java.util.ArrayList;
import java.util.List;

public class DeleteBeforeCommit {
    public static void main(String[] args) {
        int dataSize = 10000; // You can adjust this value as needed

        // Step 1: Generate a large dataset
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= dataSize; i++) {
            data.add(i);
        }

        // Step 2: Implement the operation using streams
        long startTimeStreams = System.nanoTime();
        // Perform your stream operations here (e.g., filtering, mapping, etc.)
        // For example, let's calculate the sum of all elements
        int sumWithStreams = data.stream().mapToInt(Integer::intValue).sum();
        long endTimeStreams = System.nanoTime();
        long executionTimeStreams = endTimeStreams - startTimeStreams;

        // Step 3: Implement the operation using a for loop
        long startTimeForLoop = System.nanoTime();
        // Perform your for-loop operations here (e.g., condition checks, etc.)
        // For example, let's calculate the sum of all elements
        int sumWithForLoop = 0;
        for (int num : data) {
            sumWithForLoop += num;
        }
        long endTimeForLoop = System.nanoTime();
        long executionTimeForLoop = endTimeForLoop - startTimeForLoop;

        // Step 4: Measure execution time

        // Step 5: Repeat the test (you can put this in a loop if needed)

        // Step 6: Compare results
        System.out.println("Execution time using streams: " + executionTimeStreams + " nanoseconds");
        System.out.println("Execution time using for loop: " + executionTimeForLoop + " nanoseconds");

        // Compare the results and draw conclusions based on your specific use case.
    }
}
