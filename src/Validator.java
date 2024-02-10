import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validator {

    public  Validator() {}
    public boolean validate(String arg, TypesOfArgs type, boolean isCanBeNull)   {
        if (isCanBeNull && arg.isEmpty()){return true;}
        if (!isCanBeNull && arg.isEmpty()){return false;}
        if (type.getClas()==String.class ){return true;}
        if (type.getClas()==Boolean.class){
            if (arg.equals("true") || arg.equals("false")) return true;
            else return false;
        }
        Class<?>[] parameterTypes = {String.class};
        Method method = null;
        //если это мой класс enum
        if (type.getClas()== TicketType.class ||type.getClas()== Comands.class||type.getClas()== VenueType.class ){
            arg=arg.toLowerCase();
            for (Object enumValue : type.getClas().getEnumConstants()) {
               if (enumValue.toString().equalsIgnoreCase(arg)){
                   return true;
               }
            }
            return false;
        }
        //если это класс из java.lang
        try {
            method = type.getClas().getMethod("parse"+type.getClas().getName().split("\\.")[2], parameterTypes);
            method.invoke(null, arg);
            return true;
        }catch (NumberFormatException  e){
            return false;
        }
        catch (InvocationTargetException e){
            if (e.getCause().getClass()==NumberFormatException.class)return false;
            else throw new RuntimeException(e);
        }
        catch (NoSuchMethodException | IllegalAccessException  e) {
            throw new RuntimeException(e);
        }

    }


}
