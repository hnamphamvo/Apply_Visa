package core.element;

import core.Logger;
import org.openqa.selenium.By;

public class CheckBox extends Element {
    /**
     * Instantiates a new element.
     *
     * @param locator the By locator
     */
    public CheckBox(By locator) {
        super(locator);
    }

    /**
     * Instantiates a new element.
     *
     * @param xpath the By.xpath
     */
    public CheckBox(String xpath) {
        super(xpath);
    }

    public boolean isChecked() {
        return getElement().getAttribute("checked").equals("true");
    }

    public boolean getState() {
        return isChecked();
    }

    public void check() {
        if (!isChecked()) {
            Logger.info(String.format("Check to checkbox element: %s", getLocator()));
            getElement().click();
        }
    }

    public void unCheck() {
        if (isChecked()) {
            Logger.info(String.format("Uncheck to checkbox element: %s", getLocator()));
            getElement().click();
        }
    }

    public void setCheckBox(boolean state) {
        if (state)
            check();
        else
            unCheck();
    }
}
