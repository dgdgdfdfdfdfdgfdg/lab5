package commands;

import managers.Collection;
import managers.DumpManager;
import utility.Console;

public class Save implements Command{
    private Collection collection;
    private Console console;
    public Save(Console console,Collection collection){
        this.console =console;
        this.collection = collection;
    }

    @Override
    public void execute(String arg) {

            DumpManager.saveToFile(collection);
            console.print("Коллекция успешно сохранена");


    }
}
