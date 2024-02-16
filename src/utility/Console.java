package utility;

import com.sun.jdi.Value;
import commands.Execute_Script;
import dto.TicketType;
import dto.VenueType;
import utility.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    private  Scanner fileScanner = null;
    private    Scanner defScanner = new Scanner(System.in);
    private  Scanner scanner;


    public Console() {
        defScanner = new Scanner(System.in);
        this.print("Добро пожаловать!");
        this.print("Введите help для вывода инструкции");
    }

    public String getInput() {
        String input = null;
        checkScanner();
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }

        if (input!=null) return input;
        ArrayList stack = Execute_Script.getStack();
        print("Чтение файла "+stack.get(stack.size()-1)+" окончено");
        stack.remove(stack.size()-1);
        Execute_Script.setStack(stack);

        if (stack.isEmpty()){
            selectConsoleScanner();
        }
        return  getInput();
    }
    private void  goToMenu(){
        throw new InvalidFormatExeption("Операция отменена");
    }
    public String getInputFromCommand(int minCountOfArgs,int maxCountOfArgs){
        this.print("Для отмены операции введите /");
        String input = this.getInput();
        if (input.equals("/")){
            goToMenu();
        }
        int countOfArgs = input.split(" ",-1).length ;
        if (countOfArgs < minCountOfArgs || countOfArgs>maxCountOfArgs ){
            print("Неверное число аргументов");
            return getInputFromCommand(minCountOfArgs,maxCountOfArgs);
        }
        return input;
    }


    public void checkScanner(){
        if (fileScanner==null){
            scanner=defScanner;
        }else {
            scanner =fileScanner;
        }
    }
    public void selectFileScanner(Scanner scanner) {
        this.fileScanner = scanner;
    }

    public void selectConsoleScanner() {
        this.fileScanner = null;
    }
    public void print(String s){
        System.out.println(s);
    }

}