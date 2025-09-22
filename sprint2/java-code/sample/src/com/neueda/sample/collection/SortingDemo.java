package com.neueda.sample.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sonam");
        list.add("Maaike");
        list.add("Alexa");
        System.out.println("Before Sorting --------");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("After Sorting --------");
        System.out.println(list);

    }
}
