package core;


import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver wd) {
        driver.set(wd);
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }

}
