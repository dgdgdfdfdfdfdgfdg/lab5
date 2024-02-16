package commands;


import managers.*;
import utility.*;
import dto.*;


public class Insert implements Command {
    private Collection collection;
    private Console console;

    public Insert(Console console, Collection collection) {
        this.console = console;
        this.collection = collection;

    }

    @Override
    public void execute(String idstr) {
        Long id = ValidateId.validateId(idstr, true, collection);
        CreateTicket creator = new CreateTicket(console,collection);
        collection.insertElement(creator.createTicket(id));
        console.print("Билет успешно введён");
    }
}