package commands;

import managers.Collection;
import utility.Console;
import utility.InvalidFormatExeption;

public class Info implements  Command {
    private Collection collection;
    private Console console;
    public Info(Console console,Collection collection){
        this.console =console;
        this.collection = collection;
    }
    @Override
    public void execute(String arg){
        String s = "Дата инициализации "+collection.getCurrentDate()+
                ", Тип коллекции - HashMap, Кол-во элементов "+collection.getCountOfElements();
        console.print(s);
    }
}
