package com.krk.myrest.repository;

import com.krk.myrest.model.Adress;
import com.krk.myrest.model.Customer;
import org.springframework.stereotype.Repository;
import sun.plugin.extension.NativeExtensionInstaller;

import java.util.*;

@Repository
public class PseudoDBRepository implements CustomerRepository {

    private static Long NEXT_ID = 0L;

    private static Map<Long, Customer> pseudoDB;

    static {
        pseudoDB = new HashMap<Long, Customer>();
        Adress adress = new Adress("Krakow", "Długa", "30-900");
        adress.setId(++NEXT_ID);

        Customer firstCust = new Customer("MIKI", adress);
        firstCust.setId(++NEXT_ID);

        Adress adress2 = new Adress("Krakow", "Ślusarska", "30-800");
        adress2.setId(++NEXT_ID);

        Customer secondCust = new Customer("CONTROL", adress2);
        secondCust.setId(++NEXT_ID);

        Adress adress3 = new Adress("Warszawa", "zamkowa", "00-120");
        adress3.setId(++NEXT_ID);

        Customer thirdCust = new Customer("CONTROL", adress3);
        thirdCust.setId(++NEXT_ID);

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

    public Customer saveCustomer(Customer customer) {
        if (customer.getId() == null) {

            Long nextCustomerId = NEXT_ID += 1;
            Long nextAdressId = NEXT_ID += 1;
            customer.getAdress().setId(nextAdressId);

            customer.setId(nextCustomerId);

        }

        if (pseudoDB.get(customer.getId()) == null) {
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
