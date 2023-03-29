package utils;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class DataHelper {

    @SneakyThrows
    public static Map<String, String> loadDataFromClassName() {

        StackTraceElement traceElement = Thread.currentThread().getStackTrace()[2];
        String className = traceElement.getClassName().split("\\.")[1];
        String methodName = traceElement.getMethodName();

        String json = new String(Files.readAllBytes(Paths.get("src/test/java/data/" + className + ".json")));

        Map<String, Object> parentNode = JsonHelper.convertJsonToMap(json);

        return (Map<String, String>) parentNode.get(methodName);
    }
}


