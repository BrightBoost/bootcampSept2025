package com.neueda.sample.interface1;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsAPI {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Sonam","Alexa","Rahul","Maaike");
        List<String> result=names.stream().filter(n->n.startsWith("M")).map(String::toUpperCase).toList();
        System.out.println(result);

        List<String> sorted= names.stream().sorted().toList();
        System.out.println(sorted);
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> evens=numbers.stream()
                .filter(n->n%2==0)
                .toList();
        System.out.println(evens);
        List<Integer> newNumbers= numbers.stream().map(n->n*3).toList();
        System.out.println(newNumbers);

        int sum=numbers.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

        Set<String> nameSet=names.stream().collect(Collectors.toSet());
        System.out.println(nameSet);

        names.stream().forEach(n-> System.out.println(n));
    }
}
