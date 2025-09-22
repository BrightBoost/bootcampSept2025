package org.example;

import java.util.ArrayList;
import java.util.List;

public class CollectionsAndLoopsExplained {
    static int c = 7;
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(); // List.of("Jessica", "Julia", "Harry", "Liam", "Jiayue");
        names.add("bla");
        names.add("la");
        if(names.size() > 4) {
            System.out.println("That's a lot of names");
        }

        // regular for
        for(int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
            names.set(i, names.get(i) + "!");
        }

        for(int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // foreach

        List<String> newNames = List.of("Jessica", "Julia", "Harry", "Liam", "Jiayue");
        for(String name : newNames) {
            System.out.println(name);
        }

        // while
        int i = 0;
        while(i < newNames.size()) {
            System.out.println(newNames.get(i));
            i++;
        }

    }
}
