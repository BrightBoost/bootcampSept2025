package com.example;

public class DryDemo {

    final double PI = Math.PI;

    public double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    public static void main(String[] args) {

        DryDemo d1 = new DryDemo();
        d1.calculateCircleArea(5);
        d1.calculateCircleArea(10);
        d1.calculateCircleArea(15);
    }
}
