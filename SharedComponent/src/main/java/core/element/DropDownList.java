package core.element;

import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DropDownList extends Element {
    private String listPanel = "//div[@class='ng-dropdown-panel-items scroll-host']";

    public DropDownList(String xpath) {
        super(xpath);
    }


    public void selectByValue(String value) {
        this.open();
        WebElement option = getElement().findElement(By.xpath(listPanel + "//div[@role='option']/span[contains(text(),'" + value + "')]"));
        Logger.info(String.format("Select option: %s", value));
        option.click();
    }

    private void open() {
        Logger.info("Open the dropdown list");
        getElement().findElement(By.xpath(".//span[@class='ng-arrow-wrapper']")).click();
    }
}