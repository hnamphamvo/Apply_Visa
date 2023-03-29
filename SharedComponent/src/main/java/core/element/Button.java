package core.element;

import org.openqa.selenium.By;

public class Button extends Element {
    /**
     * Instantiates a new element.
     *
     * @param locator the By locator
     */
    public Button(By locator) {
        super(locator);
    }

    /**
     * Instantiates a new element.
     *
     * @param xpath the By.xpath
     */
    public Button(String xpath) {
        super(xpath);
    }
}
