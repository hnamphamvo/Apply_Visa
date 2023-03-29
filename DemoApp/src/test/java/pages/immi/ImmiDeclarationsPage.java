package pages.immi;

import core.element.Element;

public class ImmiDeclarationsPage extends GeneralPage{
    private Element getPageRadioButton(String label, String value) {
        return new Element(String.format("//span[contains(text(),'%s')]/../following-sibling::div//input[@value=%s]", label, value));
    }

    private void selectPageRadioButton(String label, String value) {
        if (value.equals("Yes")) {
            this.getPageRadioButton(label, "1").click();
        } else this.getPageRadioButton(label, "2").click();
    }

    public void selectDeclarations() {
        this.selectRadioButton01("Have read and understood the information", "Yes");
        this.selectRadioButton01("Have provided complete and correct information", "Yes");
        this.selectRadioButton01("Understand that if any fraudulent documents", "Yes");
        this.selectRadioButton01("Understand that if documents are found to be fraudulent", "Yes");
        this.selectRadioButton01("Understand that if this application is approved, any person", "Yes");
        this.selectRadioButton01("Will inform the Department in writing immediately", "Yes");
        this.selectPageRadioButton("Have read the information contained in the Privacy Notice", "Yes");
        this.selectPageRadioButton("Understand that the department may collect, use and disclose", "Yes");
        this.selectRadioButton01("Give consent to the collection of their fingerprints", "Yes");
        this.selectRadioButton01("Understand that, if required to provide their fingerprints and facial image", "Yes");
        this.selectRadioButton01("Give consent to Australian law enforcement agencies", "Yes");
        this.selectRadioButton01("Give consent to the Department using the applicant", "Yes");
        this.selectRadioButton01("I understand that if my visa ceases to be in effect", "Yes");
        this.selectRadioButton01("Each applicant who is 18 years or over has read", "Yes");
    }
}
