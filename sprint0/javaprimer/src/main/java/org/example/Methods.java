package org.example;

public class Methods {
    static int x = 4;
    static int y = 5;

    public static int add(int x, int y) {
        x = 6;
        return x + y;
    }

    public static void printAddition(int x, int y) {
        System.out.println("Adding: " + x + " and " + y + " = " + (x + y));
    }

    public static void main(String[] args) {
        System.out.println(add(x, y));
        System.out.println(x);
        printAddition(6, 7);
    }
}
