package utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Utilities {

    public static String readFileFromFilePath(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return String.join("", Files.readAllLines(path));
    }

    public static boolean isNullOrEmpty(String string) {
        if (string == null)
            return true;
        return string.isEmpty();
    }

    public static String executeCommand(String command) {
        StringBuilder response = new StringBuilder();
        String line;
        ProcessBuilder builder = new ProcessBuilder(command.split(" "));
        builder.redirectErrorStream(true);
        Process process;
        try {
            process = builder.start();
            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response.toString();
    }

    public static void sleep(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getTestCaseID() {
        String tcID = null;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement item : stackTraceElements) {
            if (item.getClassName().startsWith("tests")) {
                assert item.getFileName() != null;
                tcID = item.getFileName().split("_")[0].toLowerCase();
            }
        }
        return tcID;
    }
}
