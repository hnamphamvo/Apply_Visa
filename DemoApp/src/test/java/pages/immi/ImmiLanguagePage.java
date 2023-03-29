package pages.immi;

import core.element.Element;
import utils.Utilities;

import java.time.Duration;

public class ImmiLanguagePage extends GeneralPage {
    public Element getSelectBoxFunctionalEnglish(String value) {
        return new Element(String.format("//span[contains(text(),'options which represent proof of the applicant')]/../..//input[@value=%s]", value));
    }

    public Element getSelectBoxFunctionalEnglishChecked(String value) {
        return new Element(String.format("//span[contains(text(),'options which represent proof of the applicant')]/../..//input[@value=%s and @checked]", value));
    }

    public void selectLanguageOptions(String isEnglishCountry, String haveEnglishAbility, String proofEnglish) {
        this.selectRadioButton01("applicant hold a current passport from the USA", isEnglishCountry);
        this.selectRadioButton01("have at least functional English language ability", haveEnglishAbility);
        if (!this.getSelectBoxFunctionalEnglishChecked(proofEnglish).isVisible()) {
            this.getSelectBoxFunctionalEnglish(proofEnglish).click();
        }
    }

    public void fulfillEnglishTestDetails(String nameOfTest, String dateOfTest, String testRN, String countryTest,
                                          String languageAbility) {
        Utilities.sleep(Duration.ofSeconds(3));
        this.selectDDLByLabel("Name of test", nameOfTest);
        this.fulfillTextBox("Date of test", dateOfTest);
        this.fulfillTextBox("Test reference number", testRN);
        this.selectDDLByLabel("Country where test was undertaken", countryTest);
        this.selectDDLByLabel("Language ability", languageAbility);
    }

    public void selectMainLanguage(String mainLanguage) {
        this.selectDDLByLabel("Main language", mainLanguage);
    }
}
