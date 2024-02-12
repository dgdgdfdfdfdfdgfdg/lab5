import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.HashMap;

    public class DumpManager {
        public static String convertToJson(HashMap<Long, Ticket> hashMap) {
            Gson gsonBuiler = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateFormating())
                    .create();
            return gsonBuiler.toJson(hashMap);
        }


    }
