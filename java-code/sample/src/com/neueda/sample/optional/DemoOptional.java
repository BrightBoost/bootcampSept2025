package com.neueda.sample.optional;

import java.util.Optional;

public class DemoOptional {

    public static void main(String[] args) {
        String name=null;
        //without optional
        if(name!=null)
            System.out.println(name.toUpperCase());

        //with optional
        Optional<String> fullname=Optional.ofNullable(name);
        fullname.ifPresent(n-> System.out.println(n.toUpperCase()));

        Optional<String> opt= Optional.of("Java");
        System.out.println(opt.get());
        opt.ifPresent(val-> System.out.println(val));

        System.out.println(opt.orElse("Default"));
        //ternary way
    }
}
