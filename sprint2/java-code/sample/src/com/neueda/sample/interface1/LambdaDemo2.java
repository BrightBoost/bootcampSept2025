package com.neueda.sample.interface1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo2 {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Sonam","Maaike","Alexa");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        Collections.sort(names,(a,b)->a.compareTo(b));
    }
}
