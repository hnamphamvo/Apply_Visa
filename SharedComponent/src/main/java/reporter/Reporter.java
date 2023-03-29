package reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * extentTestMap holds the information of thread ids and ExtentTest instances.
 * ExtentReports instance created by calling createExtentReports() method from ExtentManager.
 * At startTest() method, an instance of ExtentTest created and put into extentTestMap with current thread id.
 * At getTest() method, return ExtentTest instance in extentTestMap by using current thread id.
 */

public class Reporter {
    static        Map<Long, ExtentTest> extentTestMap = new HashMap<>();
    public static ExtentReports         reports       = ExtentReport.createExtentReports();
    static        ExtentTest            test;

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        reports.flush();
    }

    public static synchronized void startTest(String testName) {
        test = reports.createTest(testName);
        extentTestMap.put(Thread.currentThread().getId(), test);
    }

    public static void logTestStep(String description) {
        getTest().info(MarkupHelper.createLabel(description, ExtentColor.TEAL));
    }

    public static void info(String description) {
        getTest().info(description);
    }

    public static void pass(String description) {
        getTest().pass(MarkupHelper.createLabel(description, ExtentColor.GREEN));
    }

    public static void fail(String description) {
        getTest().fail(description);
    }
}