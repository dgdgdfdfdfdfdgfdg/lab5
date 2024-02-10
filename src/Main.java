import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Collection collection = new Collection();
        ExecutorOfComands executor = new ExecutorOfComands(collection);
        Console input = new Console();
        ParseInput parseInput = new ParseInput();
        Validator validator = new Validator();

        while (true){
            String s = input.getInput();
            if (!s.isEmpty()) {
                try {
                    parseInput.parseInput(s);
                    executor.executeComand(parseInput.getArg1(), parseInput.getArg2(), parseInput.getArg3AndNext());
                } catch (InvalidFormatExeption e) {
                    System.out.println(e.getMessage());
                }
            }

        }



    }
}
