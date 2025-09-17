package com.neueda.dependecyinjection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet{
    private static final Logger logger= LoggerFactory.getLogger(Cat.class);
    @Override
    public void feed() {
        logger.info("Feeding Cat...");
    }
}
