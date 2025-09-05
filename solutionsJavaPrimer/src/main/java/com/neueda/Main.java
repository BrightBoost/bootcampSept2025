package com.neueda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // primitives - 8 types - sizes are roughly
        boolean yes = true; // true or false values
        byte smallNr = 100; // -128 to 127
        char character = 'c'; // 0 up to somewhere around 65000
        short shortNrs = 30000; // around -32500 to 32500
        int nr = 1; // negative 2^31 to positive 2^31
        long bigNr = 12345678900L; // negative 2^63 to positive 2^63
        float weight = 4.5F; // smaller dcimal nrs
        double weight2 = 4.5; // bigger decimal nrs
        yes = false;
        character = (char) nr; // cast to another type

        // objects - infinite nr of options
        String text = "Like this";

        // collection (objects too)
        List<String> names = new ArrayList<>();
        names.add("Aruna");
        names.add("Rashi");
        names.add("Sudharsan");

        System.out.println(names.get(2));
        System.out.println(names.size());

        // list of nrs
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(10);
        numbers.add(2223);

        System.out.println(numbers.get(0));
        System.out.println("size nrs: " + numbers.size());

        // delete list element
        numbers.remove(1);
        System.out.println("size nrs: " + numbers.size() + " : " + numbers);


        // math operators - +, -, /, *, %
        int x = 6;
        int y = 2;
        int result = x / y;

        // comparison operators (results are boolean)
        // equality ==
        boolean same = x == y;
        boolean smallerThan = x < y;
        boolean smallerThanOrEqualTo = x <= y;

        // and, or, not
        boolean check = same && smallerThan; // and
        boolean check1 = same || smallerThan; // or
        boolean check2 = x == y || x > y;

        // unary operator
        x++; // x = x + 1

        System.out.println("result:" + (x + y));

        System.out.println("Hello world!");
    }
}