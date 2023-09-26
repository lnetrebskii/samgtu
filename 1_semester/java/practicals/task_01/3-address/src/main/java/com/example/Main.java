package com.example;

import com.example.model.Person;
import com.example.repository.DataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Главный класс приложения, предоставляющего функциональность для поиска и
 * просмотра информации о людях на основе данных из файла.
 */
public class Main {

  public static void main(String[] args) {
    // Загрузка данных о людях из файла
    List<Person> persons = loadPersonsData();

    // Инициализация репозитория с загруженными данными
    DataRepository repository = new DataRepository(persons);

    Scanner scanner = new Scanner(System.in);
    while (true) {
      // Предоставление пользователю меню для выбора действия
      System.out.println("Выберите операцию:");
      System.out.println("1. Поиск по фамилии");
      System.out.println("2. Поиск по атрибуту адреса");
      System.out.println("3. Вывод людей, родившихся между датами");
      System.out.println("4. Найти самого старого");
      System.out.println("5. Найти самого молодого");
      System.out.println("6. Люди, проживающие на одной улице");
      System.out.println("0. Выход");

      int choice;
      try {
        choice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Неверный ввод. Попробуйте снова.");
        continue;
      }

      List<Person> foundPersons = null;

      // Обработка выбора пользователя
      switch (choice) {
        case 1:
          System.out.println("Введите фамилию:");
          String lastName = scanner.nextLine();
          foundPersons = repository.findByLastName(lastName);
          break;
        case 2:
          System.out.println("Введите любой атрибут адреса (дом или улицу):");
          String address = scanner.nextLine();
          foundPersons = repository.findByAddressAttribute(address);
          break;
        case 3:
          System.out.println("Введите начальную дату в формате ГГГГ-ММ-ДД:");
          String startStr = scanner.nextLine();
          System.out.println("Введите конечную дату в формате ГГГГ-ММ-ДД:");
          String endStr = scanner.nextLine();
          LocalDate startDate, endDate;
          try {
            startDate = LocalDate.parse(startStr);
            endDate = LocalDate.parse(endStr);
          } catch (Exception e) {
            System.out.println("Ошибка в формате даты.");
            continue;
          }
          foundPersons = repository.findBetweenDates(startDate, endDate);
          break;
        case 4:
          foundPersons = new ArrayList<>(Arrays.asList(repository.findOldest()));
          break;
        case 5:
          foundPersons = new ArrayList<>(Arrays.asList(repository.findYoungest()));
          break;
        case 6:
          System.out.println("Введите улицу:");
          String commonStreet = scanner.nextLine();
          foundPersons = repository.findByStreet(commonStreet);
          // Добавить логику поиска по улице
          break;
        case 0:
          System.out.println("Выход...");
          return;
        default:
          System.out.println("Неверный выбор. Попробуйте снова.");
      }

      printPersonsData(foundPersons);
    }
  }

  /**
   * Загрузка данных о людях из файла в формате JSON.
   * 
   * @return Список людей, загруженных из файла.
   */
  private static List<Person> loadPersonsData() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    try {
      InputStream is = Main.class.getClassLoader().getResourceAsStream("persons.json");
      CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Person.class);
      return mapper.readValue(is, listType);
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  /**
   * Вывод списка людей на экран.
   * 
   * @param persons Список людей для вывода.
   */
  private static void printPersonsData(List<Person> persons) {
    for (Person person : persons) {
      System.out.println(person);
    }
  }
}
