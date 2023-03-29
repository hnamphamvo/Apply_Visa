package pages.immi;

public class ImmiEducationHistoryPage extends GeneralPage {
    public void fulfillEducationHistory(String qualification, String courseName, String institutionName,
                                        String countryOfInstitution, String dateFrom, String dateTo, String status) {
        this.selectDDLByLabel("Qualification", qualification);
        this.fulfillTextBox("Course name", courseName);
        this.fulfillTextBox("Institution name", institutionName);
        this.selectDDLByLabel("Country of institution", countryOfInstitution);
        this.fulfillTextBox("Date from", dateFrom);
        this.fulfillTextBox("Date to", dateTo);
        this.selectDDLByLabel("Status", status);
    }

}
