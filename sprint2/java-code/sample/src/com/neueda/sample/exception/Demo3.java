package com.neueda.sample.exception;

public class Demo3 {
    public String  searchProduct(int id) throws ProductNotFoundException{
        if(id<=0){
            throw new ProductNotFoundException("Id cannot be Negative");
        }
        return "Product Found";
    }
    public static void main(String[] args) {
        Demo3 obj = new Demo3();
        try {
            obj.searchProduct(-1);
        }catch(ProductNotFoundException e){
            System.out.println("Exception "+e.getMessage());
        }
    }
}
