package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class DataFaker {

    public static String generateRandomEmail(String email) {
        if (email.contains("@")) {
            String[] parts = email.split("@");
            String part1 = parts[0];
            String part2 = parts[1];
            return part1 + "+" + Utilities.getTestCaseID().replace("c", "") + generateTimeStampString("MMddHHmmssSSS") + "@" + part2;
        } else {
            throw new IllegalArgumentException("The String" + email + " does not contain @");
        }
    }

    /**
     * Generate a random email with specific length
     *
     * @param email
     * @param length
     * @return return new email with specific length
     */
    public static String generateRandomEmailWithLength(String email, int length) {
        String emailTemp = generateRandomEmail(email);
        String[] parts = emailTemp.split("@");
        String part1 = parts[0];
        String part2 = parts[1];
        int lengthTemp = length - emailTemp.length();
        String valueTemp = RandomStringUtils.randomNumeric(lengthTemp);
        return part1 + valueTemp + "@" + part2;
    }

    /***
     * Generate a 13-digits random number
     * @throws IOException e
     */
    public static long numbGenerator() {
        long min = 1000000000000L; //13 digits inclusive
        long max = 10000000000000L; //14 digits exclusive
        Random random = new Random();
        return min + ((long) (random.nextDouble() * (max - min)));
    }

    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String generateTimeStampString(int length) {
        String timestampStr = "";
        if (length <= 14 && length > 0) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime now = LocalDateTime.now();
            timestampStr = dtf.format(now);
        }
        return timestampStr.substring(timestampStr.length() - length);
    }

    public static String addDaysToCurrentDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, days);
        return sdf.format(cal.getTime());
    }
}
