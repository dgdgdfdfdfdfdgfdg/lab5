package utility;

import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dto.*;
import utility.*;
import commands.*;
import managers.*;
public class Main {
    public static void main(String[] args) {
        Collection collection = new Collection();
        Console console = new Console();
        ExecutorOfComands executor =new ExecutorOfComands(console,collection);
        ParseInput parseInput = new ParseInput();
        DumpManager.loadFromFile(collection);
        ValidatorOfCollection validator = new ValidatorOfCollection();
        validator.validateCollection(console,collection);
        while (true){
            String s = console.getInput();
            if (!s.isEmpty()) {
                try {
                    parseInput.parseInput(s);
                    String cmd = parseInput.getArg1();
                    String arg2= parseInput.getArg2();
                    executor.executeComand(cmd,arg2);
                } catch (InvalidFormatExeption e) {
                    console.print(e.getMessage());
                }
            }

        }



    }
}
