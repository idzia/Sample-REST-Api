package com.krk.myrest.repository;

import com.krk.myrest.model.Adress;
import com.krk.myrest.model.Customer;

import java.util.Collection;


public interface CustomerRepository {

    Collection<Customer> findAll();

    Customer findCustomerById(Long id);

//    Long saveCustomer(Customer customer);

    Customer saveCustomer(Customer customer);

//    Long updateCustomer(Customer customer, Long id);

//    void deleteCustomer(Customer customer);

    void deleteCustomer(Long id);
}
