package org.example;

public class ConditionalStatements {
    public static void main(String[] args) {
        int temp = 28;
        String weather = "sunny";
        if(weather.equals("sunny")) {
            // if true this will be executed
            System.out.println("Don't forget sunglasses");
        } else {
            // executed if false
            System.out.println("It's not sunny");
        }

        boolean bringSunglasses = weather.equals("sunny") ? true : false; // ternary statement

        if(weather.equals("sunny")) {
            // if true this will be executed
            System.out.println("Don't forget sunglasses");
        } else if(weather.equals("rainy")) {
            // executed if false
            System.out.println("Don't forget your umbrella");
        } else {
            System.out.println("meh");
        }

    }
}
