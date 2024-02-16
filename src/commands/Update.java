package commands;

import dto.Ticket;
import managers.*;
import utility.*;
import utility.InvalidFormatExeption;

public class Update implements Command {
    private Collection collection;
    private Console console;
    public Update(Console console, Collection collection){
        this.console =console;
        this.collection = collection;
    }
    public void execute(String idstr){
        Long id = ValidateId.validateId(idstr,false,collection);
        Ticket ticket = collection.getElement(Long.parseLong(idstr));
        collection.removeElement(id);
        try {
            Insert ins = new Insert (console,collection);
            ins.execute(idstr);
        }catch (InvalidFormatExeption e){
            collection.insertElement(ticket);
            System.out.println(e.getMessage());
        }
    }
}
