package com.neueda.dependencyinjection;

public class PersonServiceImpl implements PersonService {
    @Override
    public void signUp(Person p) {
        System.out.println("Signing up " + p.getName());
    }
}
