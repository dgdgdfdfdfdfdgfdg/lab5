public enum HelpComands {

    info$("""
Выводит информацию о коллекции

Команда без аргумментов
"""),
    show$("""
Выводит коллекцию

Команда без аргументов"""),
    insert$("""
                   Добавить элемент
                   
                   Формат команды: "insert id name;price;discount;refundable"
                   id -  уникальное число больше 0 
                   price - число больше 0
                   discount - число больше 0, можно указать пустую строку
                   refundable - true или false, можно указать пустую строку                                                                 
                    """),
    update$("""
                   Обновить элемент
                   
                   Формат команды: "update id name;price;discount;refundable"
                   id -  уникальное число больше 0
                   price - число больше 0
                   discount - число больше 0, можно указать пустую строку
                   refundable - true или false, можно указать пустую строку"""),
    remove_key$("""
            Удалить элемент
            
            Формат команды: remove_key id
            id - число больше 0, id Элемента
            """),
    clear$("""
            Очистить коллекцию
            
            Команда без аргументов
            """),
    save$("""
            Сохранить коллекцию
            
            Команда без аргументов
            """),
    execute_script$("""
            Выполнить скрипт из файла
            
            Формат команды: "execute_script file.txt"
            file.txt - название файла, из папки проекта или путь абсолютный путь до файла
            """),
    exit$("""
            Завершение работы
            
            Команда без аргументов
            """),
    remove_greater$("""
            Удалить элементы с ценой больше указанной
            
            Формат команды: remove_greater price
            price - Число больше 0
            """),
    replace_if_greater$("""
            Заменить цену элемента, если она выше
            
            Формат команды: replace_if_greater id price
            id - число больше 0, id Элемента
            price - Число больше 0
            """),
    remove_greater_key$("""
            Удалить элементы с id больше заданного числа
            
            Формат команды: remove_greater_key key
            key - число больше 0
            """),
    average_of_price$("""
            Вывести среднюю цену
            
            Команда без аргументов
            """),
    filter_less_than_venue$("""
            Вывести элементы у которых venue.capacity меньше данного числа
            
            Формат команды: "filter_less_than_venue capacity"
            capacity - заданное число, больше 0
            """),
    print_descending$("""
            Вывести коллекцию в обратном порядке
            
            Команда без аргументов
            """);
    private final String message;

    HelpComands(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}
