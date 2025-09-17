package com.neueda.dependecyinjection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
public class Dog implements Pet{
    private static final Logger logger= LoggerFactory.getLogger(Dog.class);
    @Override
    public void feed() {
        logger.info("Feeding Dog...");
    }
}
