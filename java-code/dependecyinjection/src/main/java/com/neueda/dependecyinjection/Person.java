package com.neueda.dependecyinjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private static final Logger logger= LoggerFactory.getLogger(Person.class);

    private final Pet pet;
    //Injected Bean using Constructor
    public Person(@Qualifier("cat") Pet pet) {
        this.pet = pet;
    }
    public void feedMyPet(){
        logger.info("I am feeding my Pet");
        pet.feed();
    }
}
