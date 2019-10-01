package com.krk.myrest.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

//@Entity
public class Customer {

//    @PositiveOrZero
    private Long id;

//    @Column
    @NotEmpty (message = "name can not be empty")
    private String name;

//    @Column
    @Valid
    private Adress adress;

    public Customer() {
    }

    public Customer(String name, Adress adress) {
        this.name = name;
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
