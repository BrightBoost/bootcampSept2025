package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // type name = value
        String firstName = "Jacqueline";
        System.out.println("Hello " + firstName);

        // primitives
        int i = 42;
        long l = 123456789098L;
        byte b = 50;
        short s = 60;

        boolean bool = true;
        float f = 2.0f;
        double d = 2.0;
        char c = 'a';

        int result = i + b;
        System.out.println(result);

        // java joke - it's not a bug it's a feature
        int i2 = Integer.MAX_VALUE;
        System.out.println(i2);
        System.out.println(i2 + 1);

        int letter = c;
        System.out.println(letter);

        // statically inferred type
        var someVariable = "lala";
        someVariable = "blabla";

        // casting - convert variables to other
        double nr1 = 6.99999;
        int nr2 = (int) nr1; // 6

        String str5 = "5";
        int int5 = Integer.parseInt(str5); // this won't be allowed: (int) str5;

        // casting "necessary" example
        int int1 = 5;
        int int2 = 2;
        double result2 = (double) int1 / int2;
        System.out.println(result2);

        String word = "Amsterdam";
        System.out.println(word.toUpperCase());
        System.out.println(word);

    }
}