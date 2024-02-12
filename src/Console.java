import com.sun.jdi.Value;

import java.util.Scanner;

public class Console {
    private  Scanner fileScanner = null;
    private  Scanner defScanner = new Scanner(System.in);
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
        return input;
    }
    private void  goToMenu(){
        throw new InvalidFormatExeption("Операция отменена");
    }
    public String getInputFromCommand(){
        this.print("Для отмены операции введите /");
        String input = this.getInput();
        if (input.equals("/")){
            goToMenu();
        }
        return input;
    }

    public void checkScanner(){
        if (fileScanner==null){
            scanner=defScanner;
        }else {
            scanner =defScanner;
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