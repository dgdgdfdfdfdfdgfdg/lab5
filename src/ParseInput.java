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

        try {
            arg1 = parts[0];
            arg2 = parts[1];
            arg2IsNotEmpty=1;
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
        return arg3;
    }
}
