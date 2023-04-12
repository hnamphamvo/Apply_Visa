package pages.immi;

import core.DriverFactory;
import core.element.Button;
import core.element.DropDownListByLabel;
import core.element.Element;
import core.element.TextBox;
import pages.SendEmailClass;
import utils.Utilities;

import java.time.Duration;

public class GeneralPage {
    public DropDownListByLabel dropDownListByLabel = new DropDownListByLabel();

    public void selectDDLByLabel(String label, String value) {
        this.dropDownListByLabel.selectByValue(label, value);
    }

    public void selectDDLByLabel1st(String label, String value) {
        this.dropDownListByLabel.selectFirstElementByValue(label, value);
    }

    public TextBox getTextBoxByLabel(String label) {
        return new TextBox(String.format("//label[contains(text(),'%s')]/../..//input", label));
    }

    public TextBox getTextBoxByLabel(String label, int index) {
        return new TextBox(String.format("(//label[contains(text(),'%s')]/../..//input)[%s]", label, index));
    }

    public void fulfillTextBox(String label, int index, String value) {
        this.getTextBoxByLabel(label, index).sendKeys(value);
    }

    public void fulfillTextBox(String label, String value) {
        this.getTextBoxByLabel(label).sendKeys(value);
    }

    public Element getRadioButtonByText(String label, String value) {
        return new Element(String.format("//span[contains(text(),'%s')]/../../following-sibling::div//input[@value=%s]", label, value));
    }

    public Element getRadioButtonByLegend(String legend, String value) {
        return new Element(String.format("//legend[contains(text(),'%s')]/following-sibling::div//input[@value='%s']", legend, value));
    }

    public void selectRadioButtonByLegend(String legend, String value) {
        if (value.equals("Yes")) {
            this.getRadioButtonByLegend(legend, "1").click();
        } else this.getRadioButtonByLegend(legend, "2").click();
    }

    public void selectRadioButton(String label, String value) {
        this.getRadioButtonByText(label, value).click();
    }

    public void selectRadioButton01(String label, String value) {
        if (value.equals("Yes")) {
            this.getRadioButtonByText(label, "1").click();
        } else this.getRadioButtonByText(label, "2").click();
    }

    public Element getRadioButtonByText(String value) {
        return new Element(String.format("(//input[@value='%s'])[1]", value));
    }

    private final Button btnContinue = new Button("//button[@name='continue']");
    private final Button btnNext = new Button("//button[@title='Go to next page']");
    private final Button btnAdd = new Button("//button[@aria-label='Add an entry to the list']");

    private final Button btnAttach = new Button("//button[text()='Attach']");

    private final Button btnConfirm = new Button("//button[text()='Confirm']");

    public void confirmForm() {
        this.btnConfirm.click();
    }

    public void attachDocument() {
        this.btnAttach.click();
    }

    public void clickAddBTN() {
        this.btnAdd.click();
    }

    public void goToApplication() {
        this.btnContinue.click();
//        DriverFactory.getDriver().navigate().refresh();
    }

    public void goToNextPage() {
        this.btnNext.click();
        DriverFactory.getDriver().navigate().refresh();
        Utilities.sleep(Duration.ofSeconds(2));
    }

    public Element getStep4Header() {
        return new Element("(//span[text()='Critical data confirmation'])[last()]");
    }

    public void checkImmiOpen() {
        if (this.getStep4Header().isVisible()) {
            DriverFactory.quitDriver();
        } else {
            new SendEmailClass().sendEmail("dotoaikhanh@gmail.com");
        }
    }

    public Element getErrorHeader() {
        return new Element("//h1//span[text()='An error has occurred']");
    }

    public void checkImmiBusy() {
        if (this.getErrorHeader().isVisible()) {
            DriverFactory.quitDriver();
        }
    }

    public Element getEditButton() {
        return new Element("//button[text()='Edit']");
    }

    public boolean checkApplicationExist() {
        if (this.getEditButton().isVisible()) {
            return true;
        } else return false;
    }
}
