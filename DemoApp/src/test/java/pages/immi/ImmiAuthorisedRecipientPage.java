package pages.immi;

import core.element.Element;
import core.element.TextBox;
import utils.Utilities;

import java.time.Duration;

public class ImmiAuthorisedRecipientPage extends GeneralPage {

    public Element getPageRadioButton(String value) {
        return new Element(String.format("//input[@value='%s']", value));
    }

    public TextBox getEmailTxt() {
        return new TextBox(String.format("(//label[contains(text(),'Email address')]/../..//input)[1]"));
    }

    public void selectAuthorisedPerson() {
        this.getPageRadioButton("NO").click();
        Utilities.sleep(Duration.ofSeconds(3));
    }

    public void fulfillEmailAddress(String isRequired, String email) {
        if (isRequired.equals("Yes")) {
            this.getEmailTxt().sendKeys(email);
        }
    }
}
