package com.example.springdatajpademo.adress;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    private Long id;
    private String city;
    private String state;
    private String streetName;
    private String zip;

    public Address() {
    }

    public Address(Long id, String streetName, String city, String state, String zip) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
