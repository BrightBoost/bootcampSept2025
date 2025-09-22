package com.neueda.sample.strings;

public class StringBuilderDemo {
    public static void main(String[] args) {
        String greeting="Hello";
        StringBuilder builder= new StringBuilder(greeting);
        builder.append("World");

        System.out.println(builder.toString());

        StringBuffer buffer=new StringBuffer(greeting);
    }
}
