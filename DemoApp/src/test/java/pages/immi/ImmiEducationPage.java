package pages.immi;

public class ImmiEducationPage extends GeneralPage {
    ImmiEducationHistoryPage immiEducationHistoryPage = new ImmiEducationHistoryPage();
    public void addEducation(String qualification, String courseName, String institutionName,
                             String countryOfInstitution, String dateFrom, String dateTo, String status) {
        if (!checkApplicationExist()) {
            this.clickAddBTN();
            immiEducationHistoryPage.fulfillEducationHistory(qualification, courseName, institutionName,
                    countryOfInstitution, dateFrom, dateTo, status);
            immiEducationHistoryPage.confirmForm();
        }
    }

    public void selectMeetEducation() {
        this.selectRadioButton01("applicant meet the education requirements", "Yes");
    }

}
