package pages.immi;

import core.element.Element;
import core.element.TextBox;

public class ImmiContactDetailsPage extends GeneralPage {
    private Element getPageOption(String option) {
        return new Element(String.format("//span[@data-wc-value='%s']", option));
    }

    public void selectCountryOfResidence(String country) {
        this.selectDDLByLabel("Usual country of residence", country);
    }

    private Element getProvinceSelectBox() {
        return new Element("(//label[text()='State or Province']/../..//select)[1]");
    }

    private Element getProvinceOption(String province) {
        return new Element(String.format("(//label[text()='State or Province']/../..//select//option[text()='%s'])[1]", province));
    }

    private TextBox getEmailTxt() {
        return new TextBox(String.format("(//label[contains(text(),'Email address')]/../..//input)[1]"));
    }

    public void selectStateOrProvince(String province) {
        this.getProvinceSelectBox().click();
        this.getProvinceOption(province).click();
    }

    public void selectDepartmentOffice(String office) {
        this.fulfillTextBox("Office", office);
        this.getPageOption(office).click();
    }

    public void fulfillResidentialAddress(String country, String address, String suburbOrTown, String stateOrProvince,
                                          String postalCode) {
        this.selectDDLByLabel1st("Country", country);
        this.fulfillTextBox("Address", address);
        this.fulfillTextBox("Suburb / Town", 2, suburbOrTown);
        this.selectStateOrProvince(stateOrProvince);
        this.fulfillTextBox("Postal code", 1, postalCode);
    }

    public void selectPostalAddress(String isTheSameResidentialAddress) {
        String label = "Is the postal address the same as the residential address?";
        if (isTheSameResidentialAddress.equals("Yes")) {
            this.selectRadioButton(label, "1");
        } else this.selectRadioButton(label, "2");
    }

    public void fulfillContactTelephoneNumber(String homePhone) {
        this.fulfillTextBox("Home phone", 1, homePhone);
    }

    public void fulfillEmailAddress(String isRequired, String email) {
        if (isRequired.equals("Yes")) {
            this.getEmailTxt().sendKeys(email);
        }
    }
}
