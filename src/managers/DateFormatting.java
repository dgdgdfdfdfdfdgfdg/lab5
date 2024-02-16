package managers;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class DateFormatting implements JsonSerializer<Date> {
    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        String myString = date.toInstant().toString();
        return new JsonPrimitive(myString);
    }
}
