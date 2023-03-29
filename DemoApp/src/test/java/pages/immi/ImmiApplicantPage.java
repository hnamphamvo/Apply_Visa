package pages.immi;

import core.element.Element;
import core.element.TextBox;

import java.awt.*;

public class ImmiApplicantPage extends GeneralPage {
    private TextBox getTextarea() {
        return new TextBox("//label[contains(text(),'applicant cannot provide details of a national identity')]/../../following-sibling::div//textarea");
    }

    public void fulfillReason() {
        this.getTextarea().sendKeys("applicant cannot provide details of a national identity card");
    }

    public void fulfillPassportDetails(String familyName, String givenName, String sexType, String dob,
                                       String ppNum, String countryPP, String nationality, String dateOfIssue,
                                       String dateOfExpiry, String placeOfIssue) {

        this.getTextBoxByLabel("Family name").sendKeys(familyName);
        this.getTextBoxByLabel("Given names").sendKeys(givenName);
        switch (sexType) {
            case "Female":
                this.getRadioButtonByText("F").click();
                break;
            case "Male":
                this.getRadioButtonByText("M").click();
                break;
            case "Other":
                this.getRadioButtonByText("x").click();
                break;
        }
        this.getTextBoxByLabel("Date of birth").sendKeys(dob);
        this.fulfillTextBox("Passport number", ppNum);
        this.selectDDLByLabel("Country of passport", countryPP);
        this.selectDDLByLabel("Nationality of passport holder", nationality);
        this.fulfillTextBox("Date of issue", dateOfIssue);
        this.fulfillTextBox("Date of expiry", dateOfExpiry);
        this.fulfillTextBox("Place of issue / issuing authority", placeOfIssue);
    }

    public void selectNationalIdentityCard(String haveIdentityCard) {
        String lblIdentityCard = "Does this applicant have a national identity card?";
        if (haveIdentityCard.equals("Yes")) {
            this.getRadioButtonByText(lblIdentityCard, "1").click();
        } else this.getRadioButtonByText(lblIdentityCard, "2").click();
    }

    public void fulfillPlaceOfBirth(String townOrCity, String stateOrProvince, String countryOfBirth) {
        this.fulfillTextBox("Town / City", townOrCity);
        this.fulfillTextBox("State / Province", stateOrProvince);
        this.dropDownListByLabel.selectByValue("Country of birth", countryOfBirth);
    }

    public void selectRelationshipStatus(String relationshipStatus) {
        this.selectDDLByLabel("Relationship status", relationshipStatus);
    }

    public void selectOtherInfo(String haveOtherName, String isCitizenOfSelectedCountryOfPP, String isCitizenOfOtherCountry,
                                String haveOtherCurrentPP, String haveOtherIdentityDoc, String haveHealthExamIn12Months) {
        if (haveOtherName.equals("Yes")) {
            this.selectRadioButton("have they ever been known by any other names", "1");
        } else this.selectRadioButton("have they ever been known by any other names", "2");

        if (isCitizenOfSelectedCountryOfPP.equals("Yes")) {
            this.selectRadioButton("citizen of the selected country of passport", "1");
        } else this.selectRadioButton("citizen of the selected country of passport", "2");

        if (isCitizenOfOtherCountry.equals("Yes")) {
            this.selectRadioButton("citizen of any other country", "1");
        } else this.selectRadioButton("citizen of any other country", "2");

        if (haveOtherCurrentPP.equals("Yes")) {
            this.selectRadioButton("have other current passports", "1");

        } else this.selectRadioButton("have other current passports", "2");

        if (haveOtherIdentityDoc.equals("Yes")) {
            this.selectRadioButton("have other identity documents", "1");

        } else this.selectRadioButton("have other identity documents", "2");


        if (haveHealthExamIn12Months.equals("Yes")) {
            this.selectRadioButton("undertaken a health examination for an Australian visa in the last 12 months", "1");

        } else
            this.selectRadioButton("undertaken a health examination for an Australian visa in the last 12 months", "2");
    }
}
