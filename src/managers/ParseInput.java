package managers;
import utility.*;

public class ParseInput   {
    private String arg1="";
    private String arg2="";
    private int arg2IsNotEmpty=0;

private String[] arg3m;
    public ParseInput(){}
    private void resetTheValues(){
        arg1="";
        arg2="";
        arg2IsNotEmpty=0;
        }
    public  void parseInput(String s ) throws InvalidFormatExeption {
        resetTheValues();
        String[] parts = s.split(" ");
        try {
            arg1 = parts[0];
            arg2 = parts[1];
            arg2IsNotEmpty=1;
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    public int getArg2IsNotEmpty(){
        return arg2IsNotEmpty;
    }


    public String getArg1() {
        return arg1;
    }
    public String getArg2() {
        return arg2;
    }
}
