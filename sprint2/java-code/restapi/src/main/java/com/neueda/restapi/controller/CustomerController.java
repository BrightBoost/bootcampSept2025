package com.neueda.restapi.controller;

import com.neueda.restapi.entity.Customer;
import com.neueda.restapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public String addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
        return "Customer Added Successfully!";
    }
    @GetMapping
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }
    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable int id){
        return service.getCustomerById(id);
    }
    @PutMapping("{id}")
    public String updateCustomer(@RequestBody Customer customer,@PathVariable int id){
        customer.setId(id);
        service.updateCustomer(customer);
        return "Customer Updated successfully!";
    }
    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable int id){
        service.deleteCustomer(id);
        return "Customer deleted Successfully!";
    }
}
