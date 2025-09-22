package com.neueda.sample.interface1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Types {
    public static void main(String[] args) {
        Supplier<String> supplier=()->"Hello From Sonam";
        System.out.println(supplier.get());

        Consumer<String> consumer= (name)-> System.out.println("Welcome "+name);
        consumer.accept("Sonam Soni");

        Predicate<Integer> predicate=(num)->num%2==0;
        System.out.println(predicate.test(34));
        System.out.println(predicate.test(37));

        Function<Integer,Integer> function=(num)->num*num;
        System.out.println(function.apply(5));
        System.out.println(function.apply(9));
    }
}
