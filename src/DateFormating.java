import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

public class DateFormating implements JsonSerializer<Date> {

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        String myString = DateFormat.getDateTimeInstance(3,3).format(date);
        JsonParser parser = new JsonParser();
        String[] parts = myString.split(",");
        String data = "{\"date\":"+parts[0]+",\"time\":\""+parts[1]+"\"}";
        // Парсинг строки JSON в объект JsonElement
        JsonElement jsonElement = parser.parse(data);
        return jsonElement;
    }

   // public void json
}
