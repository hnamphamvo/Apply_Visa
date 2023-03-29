package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import reporter.Reporter;

public class Logger {

    private static StackTraceElement getStackTraceElement(int depth) {
        return Thread.currentThread().getStackTrace()[depth];
    }

    private static void updateLogAttributes() {
        ThreadContext.put("lineNumber", String.valueOf(getStackTraceElement(4).getLineNumber()));
        ThreadContext.put("declaringClass", getStackTraceElement(4).getClassName());
        ThreadContext.put("methodName", getStackTraceElement(4).getMethodName());
        ThreadContext.put("fileName", getStackTraceElement(4).getFileName());
    }

    public static void info(String message) {
        org.apache.logging.log4j.Logger log = LogManager.getLogger(getStackTraceElement(3).getClassName());
        updateLogAttributes();
        log.info(message);
        Reporter.info(message);
    }

    public static void fail(String message) {
        org.apache.logging.log4j.Logger log = LogManager.getLogger(getStackTraceElement(3).getClassName());
        updateLogAttributes();
        log.fatal(message);
        Reporter.fail(message);
    }

    public static void error(String message, Throwable throwable) {
        org.apache.logging.log4j.Logger log = LogManager.getLogger(getStackTraceElement(3).getClassName());
        updateLogAttributes();
        log.error(message, throwable);
        Reporter.fail(String.valueOf(throwable));
    }

    public static void warning(String message) {
        org.apache.logging.log4j.Logger log = LogManager.getLogger(getStackTraceElement(3).getClassName());
        updateLogAttributes();
        log.warn(message);
    }
}
