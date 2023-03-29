package pages.immi;

import enums.ApplicationType;

public class ImmiApplicationContextPage extends GeneralPage {
    public void selectCurrentLocation(String location) {
        dropDownListByLabel.selectByValue("Current location", location);
    }

    public void selectLegalStatus(String status) {
        dropDownListByLabel.selectByValue("Legal status", status);
    }

    public void selectCurrentLocation(String location, String status) {
        this.selectCurrentLocation(location);
        this.selectLegalStatus(status);
    }

    public void selectCurrentApplication(String dependentChildren, String subclass417) {
        String label01 = "dependent children";
        String label02 = "subclass 417";

        if (dependentChildren.equals("Yes")) {
            this.getRadioButtonByText(label01, "1").click();
        } else this.getRadioButtonByText(label01, "2").click();

        if (subclass417.equals("Yes")) {
            this.getRadioButtonByText(label02, "1").click();
        } else this.getRadioButtonByText(label02, "2").click();
    }

    public void selectApplicationType(String type, boolean subclass462) {
        String label01 = "type of work and holiday visa";
        String label02 = "subclass 462";

        switch (type) {
            case "First Work and Holiday visa (subclass 462)":
                this.getRadioButtonByText(label01, "4").click();
                break;
            case "Second Work and Holiday visa (subclass 462)":
                this.getRadioButtonByText(label01, "5").click();
                break;
            case "Third Work and Holiday visa (subclass 462)":
                this.getRadioButtonByText(label01, "6").click();
                break;
        }

        if (subclass462) {
            this.getRadioButtonByText(label02, "1").click();
        } else this.getRadioButtonByText(label02, "2").click();
    }

    public void inputProposedArrivalDate(String date) {
        this.getTextBoxByLabel("Proposed arrival date").sendKeys(date);
    }

    public void selectGovernmentSupport(String haveLetter) {
        String label = "have a letter of government support";
        if (haveLetter.equals("Yes")) {
            this.getRadioButtonByText(label, "1").click();
        } else this.getRadioButtonByText(label, "2").click();
    }

    public void completeStep2(String location, String status) {
        this.selectCurrentLocation(location);
        this.selectLegalStatus(status);
        this.selectCurrentApplication("No", "Yes");
    }
}
