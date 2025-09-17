package com.neueda.restapi.service;

import com.neueda.restapi.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(int id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int id);
}
