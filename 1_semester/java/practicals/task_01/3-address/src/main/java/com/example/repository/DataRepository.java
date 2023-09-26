package com.example.repository;

import com.example.model.Person;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Репозиторий для работы с данными о людях.
 * Предоставляет методы для поиска и фильтрации информации о людях.
 */
public class DataRepository {

  // Список людей, с которыми работает репозиторий
  private List<Person> persons;

  /**
   * Конструктор класса.
   * 
   * @param persons Список людей для инициализации репозитория.
   */
  public DataRepository(List<Person> persons) {
    this.persons = persons;
  }

  /**
   * Поиск людей по фамилии.
   * 
   * @param lastName Фамилия для поиска.
   * @return Список людей с указанной фамилией.
   */
  public List<Person> findByLastName(String lastName) {
    return persons.stream()
        .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
        .collect(Collectors.toList());
  }

  /**
   * Поиск людей по атрибуту адреса (улица или номер дома).
   * 
   * @param address Атрибут адреса для поиска.
   * @return Список людей, соответствующих указанному атрибуту адреса.
   */
  public List<Person> findByAddressAttribute(String address) {
    return persons.stream()
        .filter(person -> person.getAddress().getStreet().equalsIgnoreCase(address)
            || person.getAddress().getHouseNumber().equalsIgnoreCase(address))
        .collect(Collectors.toList());
  }

  /**
   * Поиск людей, родившихся между определенными датами.
   * 
   * @param startDate Начальная дата.
   * @param endDate   Конечная дата.
   * @return Список людей, родившихся между указанными датами.
   */
  public List<Person> findBetweenDates(LocalDate startDate, LocalDate endDate) {
    return persons.stream()
        .filter(person -> (person.getBirthDate().isAfter(startDate) || person.getBirthDate().isEqual(startDate))
            && (person.getBirthDate().isBefore(endDate) || person.getBirthDate().isEqual(endDate)))
        .collect(Collectors.toList());
  }

  /**
   * Поиск самого старого человека.
   * 
   * @return Самый старый человек из списка.
   */
  public Person findOldest() {
    return persons.stream()
        .min(Comparator.comparing(Person::getBirthDate))
        .orElse(null);
  }

  /**
   * Поиск самого молодого человека.
   * 
   * @return Самый молодой человек из списка.
   */
  public Person findYoungest() {
    return persons.stream()
        .max(Comparator.comparing(Person::getBirthDate))
        .orElse(null);
  }

  /**
   * Поиск людей по улице проживания.
   * 
   * @param street Улица для поиска.
   * @return Список людей, проживающих на указанной улице.
   */
  public List<Person> findByStreet(String street) {
    return persons.stream()
        .filter(person -> person.getAddress().getStreet().equalsIgnoreCase(street))
        .collect(Collectors.toList());
  }
}
