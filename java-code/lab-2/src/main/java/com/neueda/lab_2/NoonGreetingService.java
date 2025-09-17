package com.neueda.lab_2;

//@Component
public class NoonGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Good AfterNoon";
    }
}
