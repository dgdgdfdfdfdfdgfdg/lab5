import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
    public class DumpManager {
        public static void loadFromFile(Collection collection) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                File file = new File("file.json");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    stringBuilder.append(scanner.nextLine());
                }
                if (!stringBuilder.isEmpty()){
                    collection.addHashMap(DumpManager.parseJson(stringBuilder.toString()));
                }

                // Закройте Scanner после завершения чтения файла
                scanner.close();
            } catch (FileNotFoundException e) {
                // Обработайте исключение, если файл не найден
                e.printStackTrace();
            }
        }

        public static void saveToFile(Collection collection){
            String json = DumpManager.convertToJson(collection.getHashMap());
            // Путь к файлу, который нужно перезаписать
            String filePath = "file.json";

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                // Преобразование строки в массив байтов
                byte[] bytes = json.getBytes();
                // Запись массива байтов в файл
                fos.write(bytes);
            } catch (IOException e) {
                System.err.println("Ошибка при записи файла: " + e.getMessage());
            }
        }
        public static String convertToJson(HashMap<Long, Ticket> hashMap) {
            Gson gsonBuiler = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateFormating())
                    .create();
            return gsonBuiler.toJson(hashMap);
        }
        public static HashMap<Long,Ticket> parseJson(String json) {
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Long, Ticket>>(){}.getType();
            HashMap<Long, Ticket> hashMap = gson.fromJson(json, type);
            return hashMap;
        }
    }