package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import core.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonHelper {

    public static List<String> convertJsonToList(String json) {
        try {
            Type mapType = new TypeToken<List<String>>() {
            }.getType();
            Gson gson = new Gson();
            return gson.fromJson(json, mapType);
        } catch (Exception e) {
            Logger.warning(e.getMessage());
            throw e;
        }
    }

    public static <T> Map<String, T> convertJsonToMap(String json) {
        try {
            Type mapType = new TypeToken<Map<String, T>>() {
            }.getType();
            Gson gson = new Gson();
            return gson.fromJson(json, mapType);
        } catch (Exception e) {
            Logger.warning(e.getMessage());
            throw e;
        }
    }

    public static <T> T convertJsonToObject(String json, Class<T> clazz) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, clazz);
        } catch (Exception e) {
            Logger.warning(e.getMessage());
            return null;
        }
    }

    public static DesiredCapabilities convertJsonToCapabilities(String json) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, String> caps = JsonHelper.convertJsonToMap(json);
        if (caps != null) {
            Set<String> keys = caps.keySet();
            for (String key : keys) {
                capabilities.setCapability(key, caps.get(key));
            }
        }
        return capabilities;
    }

    public static String convertObjectToPrettyJsonString(Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(obj);
        } catch (Exception e) {
            Logger.warning(e.getMessage());
            return null;
        }
    }
}
