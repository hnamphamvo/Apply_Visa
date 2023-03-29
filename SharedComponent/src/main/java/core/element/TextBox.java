package core.element;

import core.Logger;
import org.openqa.selenium.By;
import utils.Utilities;

import java.time.Duration;

public class TextBox extends Element {
    /**
     * Instantiates a new element.
     *
     * @param locator the By locator
     */
    public TextBox(By locator) {
        super(locator);
    }

    public TextBox(String xpath) {
        super(xpath);
    }

    public void sendKeys(String value) {
        Logger.info(String.format("Send text '%s' to element: %s", value, getLocator().toString()));
        click();
        getElement().clear();
        getElement().sendKeys(value);
    }

    public void uploadFile(String value) {
        getElement().sendKeys(value);
        Utilities.sleep(Duration.ofSeconds(2));
    }

}
