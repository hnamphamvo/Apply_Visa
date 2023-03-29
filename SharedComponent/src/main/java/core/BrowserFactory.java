package core;

import utils.ReadProperties;
import core.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserFactory {

    DesiredCapabilities caps = new DesiredCapabilities();

    public WebDriver createInstance(String browser) throws Exception {

        WebDriver driver;

        switch (Browser.fromString(browser)) {

            case CHROME -> {
                WebDriverManager.chromedriver().capabilities(caps).setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--incognito");
                if (ReadProperties.getInstance().getProperty("headless").equalsIgnoreCase("true")) {
                    options.setHeadless(true);
                }
                driver = new ChromeDriver(options);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().capabilities(caps).setup();
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
            }
            default -> {
                throw new Exception("Our framework does not support this platform: " + browser);
            }
        }
        return driver;
    }

    public void setCapability(String capabilityName, String value) {
        caps.setCapability(capabilityName, value);
    }
}
