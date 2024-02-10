import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.lang.reflect.Method;
public class ExecutorOfComands {
    private Collection collection;
    public ExecutorOfComands(Collection collection){
        this.collection=collection;
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
                Class<?>[] parameterTypes = {String.class, String[].class};
                Method method = clazz.getMethod(cmd, parameterTypes);
                method.invoke(this, arg1, arg2);
            } else {
                Method method = clazz.getMethod(cmd);
                method.invoke(this);
            }
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println(e.getCause().getMessage());
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
                System.out.println(line);
            }

            // Закрываем Scanner после использования
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); // Обработка исключения, если файл не найден
        }

    }

    public void insert(String idstr, String args) {
        Long id;
        try {
            id = new Long(idstr);
        } catch (NumberFormatException e) {
            throw new InvalidFormatExeption("Неправильный формат ввода id должен быть числом");
        }
        if (collection.getHashMap().containsKey(id)) {
            throw new InvalidFormatExeption("Неправильный формат ввода id должен быть уникальным");
        }
        String[] parts = args.split(";", -1);
        //проверим аргументы

        String name = parts[0];
        Long price;
        Long discount;
        Boolean refundable = null;

        try {
            price = Long.parseLong(parts[1]);
        } catch (NumberFormatException e) {
            throw new InvalidFormatExeption("Неправильный формат ввода цена должна быть числом");
        }
        try {
            discount = Long.parseLong(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidFormatExeption("Неправильный формат ввода скидка должна быть числом");
        }
        String refundableS = parts[3];
        if (!refundableS.isEmpty()) {
            if (!refundableS.equals("true") && !refundableS.equals("false")) {
                throw new InvalidFormatExeption("Возможность возврата должна быть true или false");
            }
        }
        if (!refundableS.isEmpty()) refundable = Boolean.parseBoolean(refundableS);
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] coord = {};
        // считываем ticketType
        TicketType ticketType = null;
        while (ticketType == null) {
            System.out.println("Введите тип билета из предложенных или пустую строку");
            for (TicketType type : TicketType.values()) {
                System.out.println(type.name());
            }
            System.out.println("Для отмены операции введите /");
            input = scanner.nextLine();
            if (input.equals("/")) {
                return;
            }
            if (input.isEmpty()) {
                break;
            }
            for (TicketType type : TicketType.values()) {
                if (input.equalsIgnoreCase(type.name())) {
                    ticketType = type;
                    break;
                }
            }
            if (ticketType == null) {
                System.out.println("Вы неверно ввели тип билета");
            }
        }
        Double x = null;
        long y = -1000;
        //считываем x и y
        while (x == null || y <= -618 || coord.length != 2) {
            System.out.println("Введите координаты в формате X Y, где X число c плавающей точкой, Y целое число и  Y > -618");
            System.out.println("Для отмены операции введите /");
            input = scanner.nextLine();
            coord = input.split(" ");
            if (input.equals("/")) {
                return;
            }
            if (coord.length != 2) {
                System.out.println("Вы ввели данные в неверном формате");
                continue;
            }
            try {
                x = new Double(coord[0]);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный формат ввода X должен быть числом");
                System.out.println("Для разделения целой и дробной части используйте точку");

                continue;
            }
            try {
                y = Long.parseLong(coord[1]);
                if (y <= -618) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Y целое число и  Y>-618");

            }
        }
        //считываем venue
        String venueName = "";
        Long venueCapacity = null;
        while (venueName.isEmpty()) {
            System.out.println("Введите Место встречи и вместимость через пробел или Место встречи");
            System.out.println("Для отмены операции введите /");
            input = scanner.nextLine();
            parts = input.split(" ", -1);
            if (input.equals("/")) {
                return;
            }
            if (parts.length > 2) {
                System.out.println("Введено слишком много аргументов");
                continue;
            }
            venueName = parts[0];
            try {
                venueCapacity = Long.parseLong(parts[1]);
            } catch (ArrayIndexOutOfBoundsException ignored) {
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели число неправильного формата");
                venueName = "";
            }


        }
        VenueType venueType = null;
        while (venueType == null) {
            System.out.println("Введите тип места встречи из предложенных или пустую строку");
            for (VenueType type : VenueType.values()) {
                System.out.println(type.name());
            }
            System.out.println("Для отмены операции введите /");
            input = scanner.nextLine();
            if (input.equals("/")) {
                return;
            }
            if (input.equals("")) {
                break;
            }
            for (VenueType type : VenueType.values()) {
                if (input.toLowerCase().equals(type.name().toLowerCase())) {
                    venueType = type;
                    break;
                }
            }
            if (venueType == null) {
                System.out.println("Вы неверно ввели тип места встречи");
            }
        }
        Venue venue = new Venue(venueType, venueCapacity, venueName);
        Coordinates coordinates = new Coordinates(x, y);



        Ticket ticket= new Ticket(name,coordinates,price,discount,refundable,ticketType,venue);
        ticket.setId(id);
        collection.insertCollection(ticket);
        System.out.println("Билет успешно введён");
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
            System.out.println("Коллекция пуста");
        }
        else{collection.showCollection();}
    }
    public void info(){
        String s = "Дата инициализации "+collection.getCurrentDate()+
                ", Тип коллекции - HashMap, Кол-во элементов "+collection.getCountOfElements();
        System.out.println(s);
    }

}






