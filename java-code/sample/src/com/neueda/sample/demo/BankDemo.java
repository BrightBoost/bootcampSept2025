package com.neueda.sample.demo;

enum  TrafficSignal{

    RED("Stop"),
    GREEN("GO"),
    YELLOW("Wait");

    private String action;

    TrafficSignal(String action) {
        this.action= action;
    }

    public String getAction() {
        return action;
    }
}
enum TransactionStatus{
    SUCCESS, FAILED, PENDING
}
public class BankDemo {

    public static void main(String[] args) {
        TransactionStatus status= TransactionStatus.PENDING;

        switch (status){
            case SUCCESS:
                System.out.println("Transaction Completed Successfully");
                break;
            case FAILED:
                System.out.println("Transaction Failed");
                break;
            case PENDING:
                System.out.println("Transaction Pending");
                break;
            default:
                System.out.println("Some Internal Error");
        }
    }
}
