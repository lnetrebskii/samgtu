
# ==========================
# 1.	Оператор if: 
# ==========================

def task1_if():
  try:
      number = float(input("Введите число: "))
  
      # Проверка числа и вывод результата
      if number > 0:
          print("Положительное")
      elif number < 0:
          print("Отрицательное")
      else:
          print("Ноль")
  
  except ValueError:
      print("Пожалуйста, введите корректное число!")
      
# ==========================
# 2.	Тернарный оператор: 
# ==========================

def task2_ternary():
  try:
      number = float(input("Введите число: "))
  
      # Проверка числа и вывод результата
      resultText = "Положительное" if number > 0 else "Отрицательное" if number < 0 else "Ноль"

      print(resultText)
  
  except ValueError:
      print("Пожалуйста, введите корректное число!")
      
      
# ==========================
# 3.	Оператор While: 
# ==========================
# Задача: Найти первое число из последовательности Фибоначчи, которое больше заданного числа n.
def task3_fibonacci(n):
    a, b = 0, 1
    while True:
        if a > n:
            print(a)
            break
        a, b = b, a + b

# Задача: Вывести нечетные числа от 1 до n, пропустив числа, делящиеся на 5.
def task3_odd_numbers(n):
    i = 1
    while i <= n:
        if i % 5 == 0:
            i += 2
            continue
        if i % 2 == 1:
            print(i)
        i += 2
        
# Задача: Попросить пользователя ввести пароль до тех пор, пока он не угадает или не исчерпает 3 попытки.
def task3_guess_password():
    password = "secret"
    attempts = 3
    while attempts > 0:
        user_input = input("Введите пароль: ")
        if user_input == password:
            print("Доступ разрешен!")
            break
        attempts -= 1
    else:
        print("Доступ запрещен!")

# Задача: Запросить пользователя вводить числа до тех пор, пока сумма чисел не превысит 100, но пропускать ввод чисел, меньших 10.
def task3_sum_input():
    total_sum = 0
    while total_sum <= 100:
        try:
            number = int(input("Введите число больше 10: "))
            if number < 10:
                print("Число слишком маленькое!")
                continue
            total_sum += number
        except ValueError:
            print("Пожалуйста, введите корректное число!")
    else:
        print("Сумма чисел превысила 100!")
        
# ==========================
# 4.	Оператор For: 
# ==========================
# Задача: Найти и вывести первое простое число в списке чисел.
def task4_first_prime(numbers):
    def is_prime(num):
        if num < 2:
            return False
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                return False
        return True
    
    for number in numbers:
        if is_prime(number):
            print(number)
            break

# Задача: Вывести все числа из списка, кроме тех, что делятся на 5.
def task4_skip_divisible_by_five(numbers):
    for number in numbers:
        if number % 5 == 0:
            continue
        print(number)

# Задача: Вывести элементы списка до тех пор, пока не встретится число 42.
def task4_until_42(numbers):
    for number in numbers:
        if number == 42:
            break
        print(number)
    else:
        print("Число 42 в списке не найдено!")
        
# Задача: Вывести все числа от 1 до n, кроме тех, что делятся на 4, но остановиться, если сумма чисел превысила 100.
def task4_sum_limit(n):
    total_sum = 0
    for i in range(1, n + 1):
        if total_sum > 100:
            break
        if i % 4 == 0:
            continue
        print(i)
        total_sum += i
    else:
        print("Сумма чисел не превысила 100!")
        
# ==========================
# 5.	Примеры использования оператора range: 
# ==========================
# Использование только stop:
def task5_simple_range():
    for i in range(5):
        print(i)

# Использование start и stop
def task5_start_stop():
    for i in range(2, 7):
        print(i)

# Использование start, stop и step:
def task5_step_range():
    for i in range(2, 15, 3):
        print(i)

# Отрицательный step:
def task5_negative_step():
    for i in range(10, 0, -1):
        print(i)

# Формирование списков
def task5_list_from_range():
    even_numbers = list(range(2, 11, 2))
    print(even_numbers)