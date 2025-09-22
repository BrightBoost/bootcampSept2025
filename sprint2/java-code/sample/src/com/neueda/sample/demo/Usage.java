package com.neueda.sample.demo;

import java.util.Scanner;

public class Usage {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select your Payment method");
        String method= scanner.next();
        PaymentGateway pay = null; //interface type ref variable
        switch (method){
            case "credit": pay = new CreditCard(); break;
            case "paypal": pay = new PayPalPayment(); break;
            default:
                System.out.println("choose correct method");
                System.exit(0);
        }

        pay.pay(5600);
        System.out.println("Payment Completed Successfully");

    }
}
