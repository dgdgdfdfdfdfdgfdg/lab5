package commands;
import managers.*;
import utility.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Execute_Script implements Command{
    private Collection collection;
    private Console console;
    private static ArrayList<File> stack = new ArrayList<>();
    public Execute_Script(Console console,Collection collection){
        this.console =console;
        this.collection = collection;
    }

    public static ArrayList<File> getStack() {
        return stack;
    }

    public static void setStack(ArrayList<File> stack) {
        Execute_Script.stack = stack;
    }

    @Override
    public void execute(String arg) {
            try {
                File file = new File(arg);
                if (stack.contains(file)){
                    throw new InfinityRecursionException("Ошибка, бесконечная рекурсия");
                }
                stack.add(file);
                Scanner scanner = new Scanner(file);
                console.selectFileScanner(scanner);
            } catch (FileNotFoundException e) {
                throw new InvalidFormatExeption("Нет такого файла");
            }catch (SecurityException e){
                throw new InvalidFormatExeption("Нет прав доступа");
        }
            catch (InfinityRecursionException e){
                console.print(e.getMessage());
            }
    }
}
