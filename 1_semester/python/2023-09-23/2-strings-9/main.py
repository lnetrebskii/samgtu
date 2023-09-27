def get_input_slice_param(prompt):
    """Функция для получения параметров среза от пользователя."""
    while True:
        try:
            value = input(prompt)
            # Если пользователь вводит пустую строку, возвращаем None
            if not value:
                return None
            # Преобразуем введенное значение в число и возвращаем его
            return int(value)
        except ValueError:
            print("Некорректный ввод. Пожалуйста, введите целое число или оставьте поле пустым.")

# Запрашиваем ввод строки
input_string = input("Введите строку: ")

# Запрашиваем параметры среза
start = get_input_slice_param("Введите начальный индекс среза (оставьте пустым для начала строки): ")
stop = get_input_slice_param("Введите конечный индекс среза (оставьте пустым для конца строки): ")
step = get_input_slice_param("Введите шаг среза (оставьте пустым для шага 1): ")

# Формируем срез
sliced_string = input_string[start:stop:step]

print(f"Результат среза: {sliced_string}")
