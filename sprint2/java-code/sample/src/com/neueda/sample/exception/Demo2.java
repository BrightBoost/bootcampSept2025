package com.neueda.sample.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Demo2 {
    public void readFile() throws FileNotFoundException {
        FileReader reader= new FileReader("");
    }
    public static void main(String[] args) {

       Demo2 obj = new Demo2();
       try{
           obj.readFile();
       }catch (Exception e){
           e.printStackTrace();
           System.out.println("Exception: "+e.getMessage());
       }
    }
}
