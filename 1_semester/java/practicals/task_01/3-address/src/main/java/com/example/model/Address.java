package com.example.model;

/**
 * Класс для представления адреса человека.
 * Содержит улицу и номер дома.
 */
public class Address {
  // Улица, на которой расположен адрес
  private String street;

  // Номер дома по указанной улице
  private String houseNumber;

  /**
   * Конструктор по умолчанию.
   * Инициализирует пустой объект Address.
   */
  public Address() {
    super();
  }

  /**
   * Конструктор с параметрами для инициализации адреса.
   * 
   * @param street      Улица адреса
   * @param houseNumber Номер дома адреса
   */
  public Address(String street, String houseNumber) {
    this.street = street;
    this.houseNumber = houseNumber;
  }

  /**
   * Получение улицы адреса.
   * 
   * @return Название улицы.
   */
  public String getStreet() {
    return street;
  }

  /**
   * Установка улицы адреса.
   * 
   * @param street Название улицы для установки.
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * Получение номера дома адреса.
   * 
   * @return Номер дома.
   */
  public String getHouseNumber() {
    return houseNumber;
  }

  /**
   * Установка номера дома адреса.
   * 
   * @param houseNumber Номер дома для установки.
   */
  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  /**
   * Представление адреса в виде строки.
   * 
   * @return Строковое представление адреса.
   */
  @Override
  public String toString() {
    return "Address { street = '" + this.street + "', houseNumber=" + this.houseNumber + "}";
  }
}
