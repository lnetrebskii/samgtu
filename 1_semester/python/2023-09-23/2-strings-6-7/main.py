# ==========================
# 6.	Str + For 
# ==========================

# Перебираем символы строки; если находим stop_char, прерываем цикл; если нет, выводим сообщение после завершения цикла.
def task6_break_else(input_string, stop_char):
    for char in input_string:
        if char == stop_char:
            print(f"Обнаружен символ {stop_char}. Завершение работы.")
            break
        print(char)
    else:
        print("Заданный символ не найден.")

# Перебираем символы строки; при нахождении skip_char пропускаем его и продолжаем цикл; после завершения цикла выводим сообщение.
def task6_continue_else(input_string, skip_char):
    for char in input_string:
        if char == skip_char:
            continue
        print(char)
    else:
        print("Все символы просмотрены.")

# Перебираем символы строки; при нахождении skip_char пропускаем его; при нахождении stop_char прерываем цикл; если stop_char не найден, выводим сообщение.
def task6_complex(input_string, skip_char, stop_char):
    for char in input_string:
        if char == skip_char:
            continue
        if char == stop_char:
            print(f"Обнаружен символ {stop_char}. Завершение работы.")
            break
        print(char)
    else:
        print("Все символы просмотрены.")

# ==========================
# 6.	Операции со строками
# ==========================
def task7_display_info(string, description):
    print(f"\n{description}:")
    print("Содержание:", string)
    print("Длина:", len(string))
    print("Тип:", str(type(string)))
    print("ID:", id(string))
    
def task7():
  # Инициализация строк с фамилией, именем и отчеством
  surname = "Нетребский"
  name = "Леонид"
  patronymic = "Сергеевич"
  
  # a) Конкатенация строк
  full_name = surname + " " + name + " " + patronymic
  print("Объединенная строка:", full_name)
  
  # b) Применение функций к каждой строке и объединенной строке
  task7_display_info(surname, "Фамилия")
  task7_display_info(name, "Имя")
  task7_display_info(patronymic, "Отчество")
  task7_display_info(full_name, "Объединенная строка")
  
  # c) Проверка наличия символов в объединенной строке
  symbols = ['Л', 'е', 'z']
  
  for symbol in symbols:
      if symbol in full_name:
          print(f"Символ '{symbol}' присутствует в объединенной строке.")
      else:
          print(f"Символ '{symbol}' отсутствует в объединенной строке.")
