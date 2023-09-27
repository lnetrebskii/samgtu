# Запрашиваем ввод строки
input_string = input("Введите строку: ")

# Вводим индекс, пока не будет получено корректное значение
while True:
    try:
        index = int(input("Введите индекс: "))

        # Проверка, чтобы индекс не выходил за границы строки
        if -len(input_string) <= index < len(input_string):
            print(f"Символ с индексом {index} в строке: {input_string[index]}")
            break
        else:
            print("Индекс выходит за границы строки. Пожалуйста, попробуйте снова.")
    except ValueError:
        print("Некорректный ввод. Пожалуйста, введите целое число.")
