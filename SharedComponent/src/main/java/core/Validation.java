package core;

import lombok.SneakyThrows;
import reporter.Reporter;

import java.util.Objects;

public class Validation {

    private static String formatAssertion(Object actual, Object expected) {
        return String.format("""
                <table>
                  <tr>
                    <th>Expect</th>
                    <th>Actual</th>
                  </tr>
                  <tr>
                    <td>%s</td>
                    <td>%s</td>
                  </tr>
                </table>""", expected, actual);
    }

    private static String infoMessage;

    @SneakyThrows
    public static void textContains(String actual, String expected) {
        infoMessage = "Check Text Contains <br>";
        if (actual.contains(expected)) {
            Reporter.pass(infoMessage + formatAssertion(actual, expected));
        } else {
            Reporter.fail(infoMessage + formatAssertion(actual, expected));
            throw new Exception("Assertion Fail");
        }
    }

    @SneakyThrows
    public static void textEquals(String actual, String expected) {
        infoMessage = "Check Text Equals <br>";
        if (Objects.equals(actual, expected)) {
            Reporter.pass(infoMessage + formatAssertion(actual, expected));
        } else {
            Reporter.fail(infoMessage + formatAssertion(actual, expected));
            throw new Exception("Assertion Fail");
        }
    }

    @SneakyThrows
    public static void assertTrue(boolean bool, String message) {
        if (bool) {
            Reporter.pass(message);
        } else {
            Reporter.fail(message);
            throw new Exception("Assertion Fail");
        }
    }

    @SneakyThrows
    public static void assertFalse(boolean bool, String message) {
        if (!bool) {
            Reporter.pass(message);
        } else {
            Reporter.fail(message);
            throw new Exception("Assertion Fail");
        }
    }

}
