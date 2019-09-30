package com.krk.myrest.repository;

import com.krk.myrest.model.Adress;
import com.krk.myrest.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PseudoDBRepository implements CustomerRepository {

//    private static Map<Long, Customer> pseudoDB = new HashMap<>();
private static Map<Long, Customer> pseudoDB;

    static {
        pseudoDB = new HashMap<Long, Customer>();
        Customer firstCust = new Customer("MIKI", new Adress("Krakow","Długa","30-900"));
        Customer secondCust = new Customer("CONTROL", new Adress("Krakow","Ślusarska","30-800"));
        Customer thirdCust = new Customer("ALT", new Adress("Warszawa","zamkowa","00-120"));
        pseudoDB.put(firstCust.getId(), firstCust);
        pseudoDB.put(secondCust.getId(), secondCust);
        pseudoDB.put(thirdCust.getId(), thirdCust);
    }

    public Collection<Customer> findAll() {
        return pseudoDB.values();
    }

    public Customer findCustomerById(Long id) {
        return pseudoDB.get(id);
    }

//    public Long saveCustomer(Customer customer) {
//        if (customer.getId()==null) {
//            Long nextCustomerId = Customer.NEXT_ID += 1;
//            Long nextAdressId = Customer.NEXT_ID += 1;
//            customer.getAdress().setId(nextAdressId);
//            customer.setId(nextCustomerId);
//        }
//
//        if (pseudoDB.get(customer.getId())==null) {
//            pseudoDB.put(customer.getId(), customer);
//        } else {
//            Customer customerToUpdate = pseudoDB.get(customer.getId());
//            customerToUpdate.setName(customer.getName());
//            customerToUpdate.setAdress(customer.getAdress());
//        }
//        return customer.getId();
//    }

    public Customer saveCustomer(Customer customer) {
        if (customer.getId()==null) {
            Long nextCustomerId = Customer.NEXT_ID += 1;
            Long nextAdressId = Customer.NEXT_ID += 1;
            customer.getAdress().setId(nextAdressId);
            customer.setId(nextCustomerId);
        }

        if (pseudoDB.get(customer.getId())==null) {
            pseudoDB.put(customer.getId(), customer);
        } else {
            Customer customerToUpdate = pseudoDB.get(customer.getId());
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setAdress(customer.getAdress());
        }
        return customer;
    }

    public void deleteCustomer(Long id) {
        pseudoDB.remove(id);
    }

}
