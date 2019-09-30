package com.krk.myrest.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//@Entity
public class Adress {
//    @Id;
    private Long id;

//    @Column
    @NotEmpty
    private String city;

//    @Column
    @NotEmpty
    private String street;

//    @Column
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    private String zipCode;

    public Adress() {
    }

    public Adress(String city, String street, String zipCode) {
        Customer.NEXT_ID  += 1;
        this.id = Customer.NEXT_ID;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
