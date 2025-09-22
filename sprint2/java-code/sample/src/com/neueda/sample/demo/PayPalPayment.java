package com.neueda.sample.demo;

public class PayPalPayment implements PaymentGateway{
    @Override
    public void pay(double amount) {
        System.out.println("Payment done of "+amount+" using Paypal");
    }
}
