package com.neueda.sample.exception;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {

        try(Scanner scanner= new Scanner(System.in)){
        System.out.println("Enter numbers");
        int num1= scanner.nextInt();
        int num2= scanner.nextInt();

            int div= num1/num2;
            System.out.println("Division is "+div);
        }catch (ArithmeticException e){
            System.out.println("Exception Occured "+e.getMessage());
        }
//        finally {
//            scanner.close();
//            System.out.println("Scanner Closed");
//        }
    }
}
