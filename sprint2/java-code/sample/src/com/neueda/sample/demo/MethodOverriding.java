package com.neueda.sample.demo;

class Parent{
    void test(){
        System.out.println("Parent Test");
    }
}
class Child extends  Parent{
    @Override
    void test(){
        super.test(); //call parent class method
        System.out.println("Child Test");
    }
}
public class MethodOverriding {
    public static void main(String[] args) {
        Child c= new Child();
        c.test();// trigger child method
    }
}
