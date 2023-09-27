# ==========================
# 10. Срезы
# ==========================
def task10_slices():
    msg = "Programming in Python is fun!"
    examples = [
        msg[15:21],  # 'Python'
        msg[:12],    # 'Programming'
        msg[12:],    # ' in Python is fun!'
        msg[:],      # 'Programming in Python is fun!'
        msg[::2],    # 'Pormigi yhni u!'
        msg[::-1],   # '!nuf si nohtyP ni gnimmargorP'
        msg[5:10],   # 'ammin'
        msg[-4:-1],  # 'fun'
        msg[10:2:-1] # 'gnimmarg'
    ]
    return "\n".join(examples)

# ==========================
# 11. Замена букв в строке
# ==========================
def task11_replace():
    original = "I love cats"
    modified = original.replace("cats", "dogs")
    return modified

# ==========================
# 12. Сравнение строк
# ==========================
def task12_compare():
    str1 = "Hello"
    str2 = "hello"
    return str1.lower() == str2.lower()

# ==========================
# 13. Вывод таблицы символов
# ==========================
def task13_char_table():
    return "\n".join([f"{i}: {chr(i)}" for i in range(32, 128)])

# ==========================
# 14. Примеры использования методов
# ==========================
def task14_methods():
    text = "Hello world, world is beautiful. Yes, world is big."
    examples = [
        text.upper(),
        text.lower(),
        text.count("world"),
        text.find("world"),
        text.rfind("world"),
        text.index("world"),
        text.isalpha(),  # False, because there are spaces and punctuation
        text.split()
    ]
    return "\n".join(map(str, examples))

# Вызываем все функции в конце
print(task10_slices())
print(task11_replace())
print(task12_compare())
print(task13_char_table())
print(task14_methods())
