package org.example;

public class Calculator {
    public int add(int a,int b){
        return  a+b;
    }
    public int sub(int a,int b){
        return  a-b;
    }
    public int mul(int a,int b){
        return  a*b;
    }
    public int div(int a,int b){
        if(b==0)
            throw new ArithmeticException("cannot divide by zero");
        return  a/b;
    }
}
