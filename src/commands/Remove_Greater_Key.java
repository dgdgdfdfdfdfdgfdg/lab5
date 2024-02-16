package commands;


import managers.*;
import utility.*;
import dto.*;


public class Remove_Greater_Key implements Command{
    private Collection collection;
    private Console console;

    public Remove_Greater_Key(Console console, Collection collection){
        this.console =console;
        this.collection = collection;
    }

    @Override
    public void execute(String idstr) {
            Long id =ValidateId.validateId(idstr,false,collection);
            int sizeBefore = collection.getCountOfElements();
            collection.removeGreaterKey(id);
            int sizeAfter = collection.getCountOfElements();
            if (sizeAfter != sizeBefore) {
                console.print("Успешно удалено");
            }else {
                console.print("Нет таких элементов");
            }


    }
}