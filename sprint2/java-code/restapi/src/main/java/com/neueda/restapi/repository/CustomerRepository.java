package com.neueda.restapi.repository;

import com.neueda.restapi.entity.Customer;
import org.springframework.stereotype.Repository;;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> list=new ArrayList<>();

    public void addCustomer(Customer customer){
        list.add(customer);
    }
    public List<Customer> getAllCustomers(){
        return  list;
    }
    public Customer getCustomerById(int id){
        return list.stream()
                .filter(c->c.getId()==id)
                .findFirst()
                .orElse(null);
    }
    public void updateCustomer(Customer customer){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==customer.getId()){
                list.set(i,customer);
                return;
            }
        }
    }
    public void deleteCustomer(int id){
        list.removeIf(c->c.getId()==id);
    }
}
