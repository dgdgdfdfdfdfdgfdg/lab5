import com.sun.jdi.Value;

import java.util.Scanner;

public class Console {
    private static Scanner fileScanner = null;
    private static Scanner defScanner = new Scanner(System.in);
    private static Scanner scanner;
    private static ParseInput parseInput;

    private boolean isTheMenuMod=true;

    public Console() {
        defScanner = new Scanner(System.in);
        this.print("Добро пожаловать!");
        this.print("Введите help для вывода инструкции");
        parseInput = new ParseInput();

    }

public void menu(){

    while (true){
        String s = this.getInput();
        if (!s.isEmpty()) {
            try {
                parseInput.parseInput(s);
                executor.executeComand(parseInput.getArg1(), parseInput.getArg2(), parseInput.getArg3AndNext());
            } catch (InvalidFormatExeption e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
    public String getInput() {
        String input = null;
        checkScanner();
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        return input;
    }
    public String getOneValue(String name,String arg1,String arg2,String[] args3,TypesOfArgs types){
        String s = this.getInput();
    }
    public void checkScanner(){
        if (fileScanner==null){
            scanner=defScanner;
        }else {
            scanner =defScanner;
        }
    }
    public void print(String s){
        System.out.println(s);
    }

    public boolean getIsTheMenuMod() {
        return isTheMenuMod;
    }
}