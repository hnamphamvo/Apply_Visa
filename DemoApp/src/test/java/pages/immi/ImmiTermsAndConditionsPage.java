package pages.immi;

import core.element.Button;

public class ImmiTermsAndConditionsPage extends GeneralPage {
    private final Button ckbAgree = new Button("//input[@type='checkbox']");

    public void agreeTermsAndConditions(boolean isApplicationExist) {
        if (!isApplicationExist) {
            this.ckbAgree.click();
        }
    }
}
