import java.util.Scanner;

public class ParseInput   {
    private String arg1="";
    private String arg2="";
    private String arg3="";
    private int countArg3AndNext=0;
    private int arg2IsNotEmpty=0;

private String[] arg3m;
    public ParseInput(){}
    private void resetTheValues(){
        arg1="";
        arg2="";
        arg3="" ;
        countArg3AndNext=0;
        }
    public  void parseInput(String s ) throws InvalidFormatExeption {
        resetTheValues();
        String[] parts = s.split(" ");

        if (parts.length > 3) {
            throw new InvalidFormatExeption("Слишком много аргументов");
        }
        try {
            arg1 = parts[0];
            boolean found = false;
            for (Comands comands : Comands.values()) {
                if (arg1.equals(comands.name())) {
                    found = true;
                    break;
                }
            }

            if (found == false) {
                throw new InvalidFormatExeption("Неверная команда");
            }


        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidFormatExeption("Вы ничего не ввели");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            arg2 = parts[1];
            arg2IsNotEmpty=1;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            arg3 = parts[2];
            countArg3AndNext = (int) arg3.chars().filter(ch -> ch == ';').count()+1;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public int getArg2IsNotEmpty(){
        return arg2IsNotEmpty;
    }

    public int getCountArg3AndNext() {
        return countArg3AndNext;
    }

    public String getArg1() {
        return arg1;
    }

    public String getArg2() {
        return arg2;
    }
    public String getArg3AndNext() {
        return     arg3;
    }
}
