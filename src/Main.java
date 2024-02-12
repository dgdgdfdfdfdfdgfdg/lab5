import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Collection collection = new Collection();
        Console console = new Console();
        ExecutorOfComands executor =new ExecutorOfComands(collection, console);
        ParseInput parseInput = new ParseInput();

        while (true){
            String s = console.getInput();
            if (!s.isEmpty()) {
                try {
                    parseInput.parseInput(s);
                    String cmd = parseInput.getArg1();
                    if (!Validator.validate(cmd,TypesOfArgs.Command,false)) {
                        throw new InvalidFormatExeption("Неверная команда");
                    }
                    String arg2= parseInput.getArg2();
                    String arg3= parseInput.getArg3AndNext();
                    if (Comands.valueOf(cmd).getCountArgs() != parseInput.getArg2IsNotEmpty()+ parseInput.getCountArg3AndNext()){
                        throw new InvalidFormatExeption("Неправильное кол-во аргументов");
                    }
                    executor.executeComand(cmd,arg2,arg3);
                } catch (InvalidFormatExeption e) {
                    console.print(e.getMessage());
                }
            }

        }



    }
}
