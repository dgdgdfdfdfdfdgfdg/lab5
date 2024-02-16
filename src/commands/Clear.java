package commands;
import managers.*;
import utility.*;
public class Clear implements Command{
    private Collection collection;
    private Console console;
    public Clear(Console console,Collection collection){
        this.console =console;
        this.collection = collection;
    }
    @Override
    public void execute(String arg) {
        collection.clearCollection();
        console.print("Коллекция очищена");
    }
}
