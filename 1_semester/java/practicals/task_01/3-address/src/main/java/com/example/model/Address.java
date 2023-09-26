package com.example.model;

/**
 * Класс для представления адреса человека.
 */
public class Address {
    private String street;
    private String houseNumber;

    public Address() {
        super();
    }

    public Address(String street, String houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
    
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address { street = '" + this.street + "', houseNumber=" + this.houseNumber + "}";
    }
}
