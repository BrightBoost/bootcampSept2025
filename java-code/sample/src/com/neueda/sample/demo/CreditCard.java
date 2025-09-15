package com.neueda.sample.demo;

public class CreditCard implements PaymentGateway{
    @Override
    public void pay(double amount) {
        System.out.println("Payment done "+amount+" using credit card");
    }
}
