package reporter;

import utils.ReadProperties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {

    static ExtentReports reports;

    @SneakyThrows
    public synchronized static ExtentReports createExtentReports() {

        Date currDate = new Date();
        String sb = ReadProperties.getInstance().getProperty("reportStorePath") +
                new SimpleDateFormat("dd-MM-yyy").format(currDate) +
                "/report-" + new SimpleDateFormat("HH_mm_ss").format(currDate) + ".html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(sb);
        setConfig(reporter);
        reports = new ExtentReports();
        reports.attachReporter(reporter);
        return reports;
    }

    private static void setConfig(ExtentSparkReporter reporter) {
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setEncoding("UTF-8");
        reporter.config().setProtocol(Protocol.HTTPS);
        reporter.config().setTimelineEnabled(true);
        reporter.config().enableOfflineMode(false);
        reporter.config().thumbnailForBase64(true);
        reporter.config().setDocumentTitle("Extent Report");
        reporter.config().setReportName("Demo App");
        reporter.config().setTimeStampFormat("MMM dd, yyyy hh:mm:ss a");
    }
}
