package core.element;

import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DropDownListByLabel extends Element {

    public DropDownListByLabel() {
        super("//body");
    }

    public void selectByValue(String label, String value) {
        this.open(label);
        WebElement option = getElement().findElement(By.xpath("(//label[text()='" + label + "']/../..//select//option[text() = '" + value + "'])[last()]"));
        Logger.info(String.format("Select option: %s", value));
        option.click();
    }

    private void open(String label) {
        Logger.info("Open the dropdown list");
        getElement().findElement(By.xpath("(.//label[text()='" + label + "']/../..//select)[last()]")).click();
    }

    public void selectFirstElementByValue(String label, String value) {
        this.openFirstElement(label);
        WebElement option = getElement().findElement(By.xpath("(//label[text()='" + label + "']/../..//select//option[text() = '" + value + "'])[1]"));
        Logger.info(String.format("Select option: %s", value));
        option.click();
    }

    private void openFirstElement(String label) {
        Logger.info("Open the dropdown list");
        getElement().findElement(By.xpath("(.//label[text()='" + label + "']/../..//select)[1]")).click();
    }
}