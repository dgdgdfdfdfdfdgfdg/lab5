package commands;

import managers.Collection;
import utility.InvalidFormatExeption;
import utility.TypesOfArgs;
import utility.Validator;

public class ValidateId {
    public static Long validateId(String idstr, boolean mustBeUnique, Collection collection){
        if (!Validator.validate(idstr, TypesOfArgs.Long,false)){
            throw new InvalidFormatExeption("Id должен быть числом");
        }
        Long id = Long.parseLong(idstr);
        if (id<=0){
            throw new InvalidFormatExeption("Id должен быть больше нуля");
        }
        String ne = mustBeUnique ? "" :" не";
        if (mustBeUnique == collection.getHashMap().containsKey(id)) {
            throw new InvalidFormatExeption("Неправильный формат ввода id"+ne +" должен быть уникальным");
        }
        return Long.parseLong(idstr);
    }
}
