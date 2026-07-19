package org.example.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pincode;
}
