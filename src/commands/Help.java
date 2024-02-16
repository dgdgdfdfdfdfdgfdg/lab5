package commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dto.*;
import utility.*;
import commands.*;
import managers.*;
public class Help implements Command {
    private Collection collection;
    private Console console;
    public Help(Console console,Collection collection){
        this.console =console;
        this.collection = collection;
    }
    @Override
    public void execute(String arg) {
        String filePath = "help.txt";
        // Создаем объект File
        File file = new File(filePath);
        try {
            // Создаем объект Scanner для чтения файла
            Scanner scanner = new Scanner(file);

            // Читаем файл построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                console.print(line);
            }
            // Закрываем Scanner после использования
            scanner.close();
        } catch (FileNotFoundException e) {
            console.print(e.getMessage()); // Обработка исключения, если файл не найден
        }
}
}
