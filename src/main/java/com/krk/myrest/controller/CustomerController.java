package com.krk.myrest.controller;

import com.krk.myrest.model.Customer;
import com.krk.myrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    private CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<Collection<Customer>> getAllCustomers() {
        Collection<Customer> customerCollection = customerService.findAll();

        return new ResponseEntity<>(customerCollection, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {

        if (id < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect ID number");
        }
        if (customerService.findCustomerById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> saveNewCustomer(@Valid @RequestBody Customer newCustomer) {
        Customer customer = customerService.saveCustomer(newCustomer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer newCustomer, @PathVariable Long id) {

        if (customerService.findCustomerById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect ID number");

        } else {
            Customer customerToUpdate = customerService.findCustomerById(id);

            updateBySetters(customerToUpdate, newCustomer);

            customerService.saveCustomer(customerToUpdate);

            return new ResponseEntity<>(customerToUpdate, HttpStatus.OK);
        }
    }

    private void updateBySetters(Customer customerToUpdate, Customer newCustomer) {

        customerToUpdate.setName(newCustomer.getName());
        customerToUpdate.getAdress().setCity(newCustomer.getAdress().getCity());
        customerToUpdate.getAdress().setStreet(newCustomer.getAdress().getStreet());
        customerToUpdate.getAdress().setZipCode(newCustomer.getAdress().getZipCode());
    }

    @DeleteMapping("customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        if (customerService.findCustomerById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect ID number");
        } else {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }
    }
}
