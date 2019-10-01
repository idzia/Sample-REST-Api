package com.krk.myrest.controller;

import com.krk.myrest.model.Customer;
import com.krk.myrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/customers")
//    public Collection<Customer> getAllCustomers() {
//        return customerService.findAll();
//    }

    @GetMapping("/customers")
    public ResponseEntity<Collection<Customer>> getAllCustomers() {
        Collection<Customer> customerCollection = customerService.findAll();

        return new ResponseEntity<>(customerCollection, HttpStatus.OK);
    }

//    @GetMapping("/customers/{id}")
//    public Customer getCustomerById(@PathVariable Long id) {
//        return customerService.findCustomerById(id);
//    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        if (customerService.findCustomerById(id)==null) {
//            HttpHeaders responseHeaders = new HttpHeaders();
//            responseHeaders.add("find by ID","This ID does not exist");
//            return new ResponseEntity<>(new Customer(), responseHeaders, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new Customer(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
        }
//        Customer customer = customerService.findCustomerById(id);
//
//        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> saveNewCustomer(@Valid @RequestBody Customer newCustomer) {
        Customer customer = customerService.saveCustomer(newCustomer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

//    @PutMapping("customers/{id}")
//    public Long updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
//
//        Customer customerToUpdate = customerService.findCustomerById(id);
//
//        customerToUpdate.setName(newCustomer.getName());
//        customerToUpdate.setAdress(newCustomer.getAdress());
//
//        return customerService.saveCustomer(customerToUpdate);
//    }

    @PutMapping("customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        Customer customerToUpdate = customerService.findCustomerById(id);

        customerToUpdate.setName(newCustomer.getName());
        customerToUpdate.setAdress(newCustomer.getAdress());

        customerService.saveCustomer(customerToUpdate);

        return new ResponseEntity<>(customerToUpdate, HttpStatus.OK);

    }

//    @DeleteMapping("customers/{id}")
//    public void deleteCustomer(@PathVariable Long id) {
//        customerService.deleteCustomer(id);
//    }

    @DeleteMapping("customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }


}
