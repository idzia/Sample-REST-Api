package com.krk.myrest.model;

//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

//@Entity
public class Customer {

    public static Long NEXT_ID = 0L;

    private Long id;

//    @Column
    @NotEmpty
    private String name;

//    @Column
    private Adress adress;

    public Customer() {
    }

    public Customer(String name, Adress adress) {
        NEXT_ID  += 1;
        this.id = NEXT_ID;
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
