package com.neueda.sample.interface1;

public class Usage {
    public static void main(String[] args) {
        //Anonymous Inner Class
        Greeting greetingObj= new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Good Morning");
            }
        };

        greetingObj.sayHello();

        Greeting obj2= () -> System.out.println("hello From Lambda");
        obj2.sayHello();
    }
}
