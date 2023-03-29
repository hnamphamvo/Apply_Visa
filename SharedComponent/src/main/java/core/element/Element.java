package core.element;

import core.DriverFactory;
import core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Element {

    protected     WebElement       _element  = null;
    protected     List<WebElement> _elements = null;
    private final By               _by;

    // Constructor
    /*
     * Get element by By locator
     */
    public Element(By byLocator) {
        this._by = byLocator;
    }

    /*
     * Get element by xpath
     */
    public Element(String xpath) {
        this._by = By.xpath(xpath);
    }

    public WebElement getElement() {
        try {
            _element = getDriver().findElement(_by);
            return _element;
        } catch (Exception e) {
            return null;
        }
    }

    public String getXPath() {
        return _by.toString().split("xpath:")[1].trim();
    }

    public WebElement get(int index) {
        return _elements.get(index);
    }

    public List<WebElement> getElements() {
        _elements = getDriver().findElements(_by);
        Logger.info("Elements size:" + _elements.size());
        return _elements;
    }

    public void waitForDisplayed(long waitingTime) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(waitingTime));
            wait.until(ExpectedConditions.visibilityOfElementLocated(_by));
        } catch (TimeoutException e) {
            Logger.warning("Element does not displays after timeout");
        }
    }

    public void waitForDisplayed() {
        this.waitForDisplayed(5);
    }

    public void waitForElementClickable(long waitingTime) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.elementToBeClickable(_by));
    }


    public void waitForNotDisplays(long waitingTime) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(_by));
    }

    // Action methods
    public void click() {
        Logger.info(String.format("Click element '%s'", getLocator().toString()));
        waitForDisplayed();
        waitForElementClickable(5);
        getElement().click();
    }

    public boolean isDisplayed() {
        try {
            if (_element == null) getElement();
            return _element.isDisplayed();
        } catch (StaleElementReferenceException e) {
            if (getElement() == null) {
                return false;
            }
            return _element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEnabled() {
        try {
            return getElement().isEnabled();
        } catch (StaleElementReferenceException e) {
            if (getElement() == null) {
                return false;
            }
            return _element.isEnabled();
        }

    }

    public boolean isVisible() {
        if (!isDisplayed()) return false;

        Dimension dims = _element.getSize();
        return dims.height > 1 && dims.width > 1;
    }

    // Getting methods
    public By getLocator() {
        return this._by;
    }

    public String getText() {
        waitForDisplayed();
        return getElement().getText();
    }

    public String getContent() {
        return getElement().getAttribute("content-desc");
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public String getContentDesc() {
        return getElement().getAttribute("content-desc");
    }

    public String getAttribute(String attribute) {
        return getElement().getAttribute(attribute);
    }
}
