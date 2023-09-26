package com.example.repository;

import com.example.model.Person;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataRepository {

    private List<Person> persons;

    public DataRepository(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> findByLastName(String lastName) {
        return persons.stream()
            .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
            .collect(Collectors.toList());
    }

    public List<Person> findByAddressAttribute(String address) {
        return persons.stream()
            .filter(person -> person.getAddress().getStreet().equalsIgnoreCase(address)
                || person.getAddress().getHouseNumber().equalsIgnoreCase(address))
            .collect(Collectors.toList());
    }

    public List<Person> findBetweenDates(LocalDate startDate, LocalDate endDate) {
        return persons.stream()
            .filter(person -> (person.getBirthDate().isAfter(startDate) || person.getBirthDate().isEqual(startDate))
                && (person.getBirthDate().isBefore(endDate) || person.getBirthDate().isEqual(endDate)))
            .collect(Collectors.toList());
    }

    public Person findOldest() {
        return persons.stream()
            .min(Comparator.comparing(Person::getBirthDate))
            .orElse(null);
    }

    public Person findYoungest() {
        return persons.stream()
            .max(Comparator.comparing(Person::getBirthDate))
            .orElse(null);
    }

    public List<Person> findByStreet(String street) {
        return persons.stream()
            .filter(person -> person.getAddress().getStreet().equalsIgnoreCase(street))
            .collect(Collectors.toList());
    }
}
