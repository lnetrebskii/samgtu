package com.example.model;

import java.time.LocalDate;

/**
 * Класс для представления человека.
 * Содержит фамилию, дату рождения и адрес.
 */
public class Person {
    // Фамилия человека
    private String lastName;

    // Дата рождения человека
    private LocalDate birthDate;

    // Адрес проживания человека
    private Address address;

    /**
     * Конструктор по умолчанию.
     * Инициализирует пустой объект Person.
     */
    public Person() {
        super();
    }

    /**
     * Конструктор с параметрами для инициализации человека.
     * 
     * @param lastName  Фамилия человека
     * @param birthDate Дата рождения человека
     * @param address   Адрес проживания человека
     */
    public Person(String lastName, LocalDate birthDate, Address address) {
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    /**
     * Получение фамилии человека.
     * 
     * @return Фамилия человека.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Получение даты рождения человека.
     * 
     * @return Дата рождения.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Получение адреса проживания человека.
     * 
     * @return Адрес проживания.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Представление человека в виде строки.
     * 
     * @return Строковое представление человека.
     */
    @Override
    public String toString() {
        return "Person { lastName ='" + this.lastName + "', address='" + this.address + "', birthDate=" + this.birthDate + "}";
    }
}
