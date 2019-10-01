package com.krk.myrest.repository;

import com.krk.myrest.model.Customer;

import java.util.Collection;


public interface CustomerRepository {

    Collection<Customer> findAll();

    Customer findCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);
}
