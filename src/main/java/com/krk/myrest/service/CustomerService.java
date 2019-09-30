package com.krk.myrest.service;

import com.krk.myrest.model.Customer;
import com.krk.myrest.repository.CustomerRepository;
import com.krk.myrest.repository.PseudoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(PseudoDBRepository pseudoDBRepository) {
        this.customerRepository = pseudoDBRepository;
    }

    public Collection<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

//    public Long saveCustomer(Customer customer) {
//        return customerRepository.saveCustomer(customer);
//    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }
}
