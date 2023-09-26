package com.example.model;

import java.time.LocalDate;

/**
 * Класс для представления человека.
 */
public class Person {
    private String lastName;
    private LocalDate birthDate;
    private Address address;

    public Person() {
        super();
    }

    public Person(String lastName, LocalDate birthDate, Address address) {
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person { lastName ='" + this.lastName + "', address='" + this.address + "', birthDate=" + this.birthDate + "}";
    }

}
