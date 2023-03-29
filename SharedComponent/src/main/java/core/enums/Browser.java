package core.enums;

import java.util.Arrays;

public enum Browser {
    CHROME, FIREFOX, IE, EDGE;

    public static Browser fromString(String type) throws Exception {
        for (Browser e : Browser.values()) {
            if (e.toString().equalsIgnoreCase(type))
                return e;
        }
        throw new Exception(String.format("Browser '%s' is not supported. Please use supported browsers: %s", type,
                Arrays.toString(Browser.values())));
    }
}
