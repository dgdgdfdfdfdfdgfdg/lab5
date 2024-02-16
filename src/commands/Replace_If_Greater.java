package commands;

import dto.Ticket;
import managers.Collection;
import managers.CreateTicket;
import utility.*;



public class Replace_If_Greater implements Command {
        private Collection collection;
        private Console console;
        public Replace_If_Greater(Console console, Collection collection){
            this.console =console;
            this.collection = collection;
        }
    public void execute(String idstr){
        ValidateId.validateId(idstr,false,collection);
        Long id = Long.parseLong(idstr);
        Ticket oldTicket = collection.getElement(id);

        CreateTicket creator = new CreateTicket(console,collection);
        Long newId = collection.getFreeId();

        Ticket newTicket = creator.createTicket(newId);

        if (newTicket.compareTo(oldTicket)>0){
            console.print("Операция прошла успешно. Замена произошла");
            collection.removeElement(id);
            newTicket.setId(id);
            collection.insertElement(newTicket);
        }
        else {
            console.print("Операция прошла успешно. Замена не произошла");
        }
    }
}
