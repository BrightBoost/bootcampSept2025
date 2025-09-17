package com.neueda.restapi.service;

import com.neueda.restapi.entity.Customer;
import com.neueda.restapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository repository;
    @Override
    public void addCustomer(Customer customer) {
        repository.addCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(int id) {
        return repository.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        repository.deleteCustomer(id);
    }
}
