package pages.immi;

import core.element.Element;

public class ImmiCriticalDataConfirmationPage extends GeneralPage {
    public Element getRadioButtonByText(String label, String value) {
        return new Element(String.format("//span[contains(text(),'%s')]/../following-sibling::div//input[@value=%s]", label, value));
    }

    public void confirmInformation(String isInfoCorrect) {
        String label = "Is the above information correct?";
        if (isInfoCorrect.equals("Yes")) {
            this.getRadioButtonByText(label, "1").click();
        } else this.getRadioButtonByText(label, "2").click();
    }
}
