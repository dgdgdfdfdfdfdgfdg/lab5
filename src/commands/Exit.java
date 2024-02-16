package commands;

import managers.Collection;
import utility.Console;

public class Exit implements Command{
    private Collection collection;
    private Console console;
    public Exit(Console console,Collection collection){
        this.console =console;
        this.collection = collection;
    }
    @Override
    public void execute(String arg) {
        console.print("Завершение работы");
        System.exit(0);
    }
}
