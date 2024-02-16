package commands;
import managers.*;
import utility.*;
public class Average_Of_Price implements Command{
    private Collection collection;
    private Console console;
    public Average_Of_Price(Console console,Collection collection){
        this.console =console;
        this.collection = collection;
    }
    @Override
    public void execute(String arg) {
            console.print("Средняя цена "+collection.getAveragePrice());

    }
}