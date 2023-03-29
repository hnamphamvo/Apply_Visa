package pages.immi;

import core.DriverFactory;
import core.element.Button;
import core.element.Element;
import utils.Utilities;

import java.time.Duration;

public class ImmiApplicationsListPage extends GeneralPage {

    ImmiNewApplicationPage immiNewApplicationPage = new ImmiNewApplicationPage();
    private final Button btnEdit = new Button("//button[text()='Edit']");

    private final Button btnAttachDocuments = new Button("//button[text()='Attach documents']");

    private final Button btnCreateNewApplication = new Button("//span[text()='New application']/../..");

    public void editApplication() {
        this.btnEdit.click();
    }

    public void attachDocuments() {
        this.btnAttachDocuments.click();
        Utilities.sleep(Duration.ofSeconds(2));
    }

    public void createNewApplication() {
        this.btnCreateNewApplication.click();
    }

    public void goToTermsAndConditions() {
        if (checkApplicationExist()) {
            this.editApplication();
        } else {
            this.createNewApplication();
            immiNewApplicationPage.selectWorkingHolidayVisa();
        }
    }

}
