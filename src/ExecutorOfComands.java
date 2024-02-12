import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.lang.reflect.Method;
public class ExecutorOfComands {
    private final Console console;
    private Collection collection;
    public ExecutorOfComands(Collection collection,Console console){
        this.collection=collection;
        this.console = console;
    }
    public void executeComand(String cmd, String arg1, String arg2) {
        try {
            // Получаем класс по его названию
            Class<?> clazz = ExecutorOfComands.class;
            if (arg1.length() > 0 && arg2.length() == 0) {
                Class<?>[] parameterTypes = {String.class};
                Method method = clazz.getMethod(cmd, parameterTypes);
                method.invoke(this, arg1);
            } else if (arg1.length() > 0 && arg2.length() > 0) {
                Class<?>[] parameterTypes = {String.class, String.class};
                Method method = clazz.getMethod(cmd, parameterTypes);
                method.invoke(this, arg1, arg2);
            } else {
                Method method = clazz.getMethod(cmd);
                method.invoke(this);
            }
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw  new InvalidFormatExeption("Неверная команда");
        } catch (InvocationTargetException e) {
            console.print(e.getCause().getMessage());
        }
    }

    public void help() {

        String filePath = "help.txt";

        // Создаем объект File
        File file = new File(filePath);

        try {
            // Создаем объект Scanner для чтения файла
            Scanner scanner = new Scanner(file);

            // Читаем файл построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                console.print(line);
            }

            // Закрываем Scanner после использования
            scanner.close();
        } catch (FileNotFoundException e) {
            console.print(e.getMessage()); // Обработка исключения, если файл не найден
        }

    }




    public void insert(String idstr, String args) {
        String[] parts = args.split(";", -1);
        //проверим аргументы
        Long id;
        if (Validator.validate(idstr,TypesOfArgs.Long,false)){
            id = new Long(idstr);
        }
        else throw new InvalidFormatExeption("Неправильный формат ввода id должен быть числом");
        if (collection.getHashMap().containsKey(id)) {
            throw new InvalidFormatExeption("Неправильный формат ввода id должен быть уникальным");
        }

        if (!Validator.validate(parts[0], TypesOfArgs.String,false)){
            throw new InvalidFormatExeption("Имя не может быть пустым");
        }
        String name = parts[0];

        if (!Validator.validate(parts[1], TypesOfArgs.Long,false)){
            throw new InvalidFormatExeption("Цена должна быть числом, не может быть null");
        }
        Long price =Long.parseLong( parts[1]);
        Long discount= null;
        if (!Validator.validate(parts[2], TypesOfArgs.Long,true)){
            throw new InvalidFormatExeption("Скидка,если есть, должна быть числом");
        }
        if (!parts[2].isEmpty()){
            discount=Long.parseLong( parts[1]);
        }

        if (!Validator.validate(parts[3], TypesOfArgs.Boolean,true)){
            throw new InvalidFormatExeption("Возможность возврата, если есть, должна быть \"true\" или \"false\"");
        }
        Boolean refundable = null;
        if (!parts[3].isEmpty()){
            refundable = Boolean.parseBoolean(parts[3]);
        }
     
        
        String input;
        String[] coord = {};
        // считываем ticketType

        String ticketTypeStr="";
        do {
            console.print("Введите тип билета из предложенных");
            for (TicketType type : TicketType.values()) {
                console.print(type.name());
            }
            ticketTypeStr= console.getInputFromCommand();
            if (!Validator.validate(ticketTypeStr,TypesOfArgs.TicketType,false)){
                console.print("Вы неверно ввели тип билета");
            }
        }
        while (!Validator.validate(ticketTypeStr,TypesOfArgs.TicketType,false));
        TicketType ticketType = TicketType.valueOf(ticketTypeStr.toUpperCase());
        Double x = null;
        long y = -1000;
        //считываем x и y
        while (x==null || y<=-618) {
            console.print("Введите координаты в формате X Y, где X число c плавающей точкой, Y целое число и  Y > -618");
            input = console.getInputFromCommand();
            ParseInput parser =new  ParseInput();
            parser.parseInput(input);
            String xstr = parser.getArg1();
            String ystr =parser.getArg2();
            if (parser.getCountArg3AndNext()!=0){
                console.print("Неверное кол-во аргументов");
            }
            else if (!Validator.validate(xstr,TypesOfArgs.Double,false)){
                console.print("X должен быть числом с плавающей точкой");
            }
            else if (!Validator.validate(ystr,TypesOfArgs.Long,false)){
                console.print("Y должен быть числом");
            }
            else {
                x = Double.parseDouble(xstr);
                y =(long) Long.parseLong(ystr);
                if (y <= -618){
                    console.print("Y должен быть больше -618");
                }
            }
        }
        //считываем venue
        String venueName = "";
        Long venueCapacity = null;
        while (venueName.isEmpty()) {
            console.print("Введите Место встречи и вместимость через пробел или Место встречи");
            input = console.getInputFromCommand();
            ParseInput parser = new ParseInput();
            parser.parseInput(input);
            if (parser.getCountArg3AndNext() != 0) {
                console.print("Введено слишком много аргументов");
                continue;
            }
            venueName = parser.getArg1();
            if (venueName.isEmpty()){
                console.print("Неверный формат ввода, вы не ввели название места встречи");
            }
            if (Validator.validate(parser.getArg2(),TypesOfArgs.Long,false)) {
                venueCapacity = Long.parseLong(parser.getArg2());
            }
        }
        VenueType venueType = null;
        while (venueType == null) {
            console.print("Введите тип места встречи из предложенных или пустую строку");
            for (VenueType type : VenueType.values()) {
                console.print(type.name());
            }
            input = console.getInputFromCommand();
            if (Validator.validate(input,TypesOfArgs.VenueType,false)){
                venueType=VenueType.valueOf(input.toUpperCase());
            }
            else if(input.isEmpty()){
                break;
            }
            else {
                console.print("Вы неверно ввели тип места встречи");
            }
        }
        Venue venue = new Venue(venueType, venueCapacity, venueName);
        Coordinates coordinates = new Coordinates(x, y);
        Ticket ticket= new Ticket(name,coordinates,price,discount,refundable,ticketType,venue);
        ticket.setId(id);
        collection.insertCollection(ticket);
        collection.update();
        System.out.println(DumpManager.convertToJson(collection.getHashMap()));
        console.print("Билет успешно введён");
    }
    public void removeKey(String idstr,String args) {
        Long id;
        try {
            id = new Long(idstr);
        } catch (NumberFormatException e) {
            throw new InvalidFormatExeption("Неправильный формат ввода id должен быть числом");
        }
        if (!collection.getHashMap().keySet().contains(id)) {
            throw new InvalidFormatExeption("Нет такого id");
        }
        collection.removeElement(id);
    }

        public void update(String idstr,String args){
       // removeKey(id);

    }

    public void exit() {
        System.exit(0);
    }

    public void show() {
        if (collection.getHashMap().isEmpty()){
            console.print("Коллекция пуста");
        }
        else{collection.showCollection();}
    }
    public void info(){
        String s = "Дата инициализации "+collection.getCurrentDate()+
                ", Тип коллекции - HashMap, Кол-во элементов "+collection.getCountOfElements();
        console.print(s);
    }

}






