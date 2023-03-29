package tests;

import utils.ReadProperties;
import core.BrowserFactory;
import core.DriverFactory;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {

    ReadProperties props = ReadProperties.getInstance();
    BrowserFactory ds    = new BrowserFactory();

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }

    @BeforeClass
    public void beforeClass() {
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser) throws Exception {
        DriverFactory.setDriver(ds.createInstance(browser));
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().navigate().to(ReadProperties.getInstance().getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
//        DriverFactory.quitDriver();
    }
}
