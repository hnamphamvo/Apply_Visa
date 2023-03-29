package pages.immi;

import core.element.Element;
import core.element.TextBox;
import utils.Utilities;

import java.time.Duration;

public class ImmiAttachDocumentsPage extends GeneralPage {
    private Element getHeader(String headerName) {
        return new Element(String.format("//h5[./span/span[text()='%s']]", headerName));
    }

    private TextBox getUploadFileTextBox(String headerName) {
        return new TextBox(String.format("(//div[./h5[./span/span[text()='%s']]]//ancestor::div[@role='tab']/following-sibling::div)[1]//input[@type='file']", headerName));
    }

    private Element getDocumentSelectBox(String headerName) {
        return new Element(String.format("(//div[./h5[./span/span[text()='%s']]]//ancestor::div[@role='tab']/following-sibling::div)[1]//select", headerName));
    }

    private Element getDocumentType(String headerName, String documentType) {
        return new Element(String.format("(//div[./h5[./span/span[text()='%s']]]//ancestor::div[@role='tab']/following-sibling::div)[1]//select//option[text()='%s']", headerName, documentType));
    }

    private void selectDocumentType(String headerName, String documentType) {
        this.getDocumentSelectBox(headerName).click();
        this.getDocumentType(headerName, documentType).click();
//        Utilities.sleep(Duration.ofSeconds(2));
    }

    public void uploadFile(String headerName, String fileName) {
        this.getUploadFileTextBox(headerName).uploadFile(fileName);
//        this.attachDocument();
    }

    public void uploadDocument(String headerName, String fileName, String documentType) {
        this.getHeader(headerName).click();
        this.selectDocumentType(headerName, documentType);
        this.uploadFile(headerName, fileName);
    }

    public void uploadDocument(String headerName, String documentType) {
        this.getHeader(headerName).click();
        this.selectDocumentType(headerName, documentType);
    }

    public void uploadTravelDocument(String fileName, String documentType) {
        String headerName = "Travel Document";
        this.uploadDocument(headerName, fileName, documentType);
    }

    public void uploadTravelDocument(String documentType) {
        String headerName = "Travel Document";
        this.uploadDocument(headerName, documentType);
    }

    public void uploadPhotographPassport(String documentType) {
        String headerName = "Photograph - Passport";
        this.uploadDocument(headerName, documentType);
    }

    public void uploadEvidenceOfFunds(String documentType) {
        String headerName = "Evidence of funds for stay in Australia and departure";
        this.uploadDocument(headerName, documentType);
    }

    public void uploadLanguageAbility(String documentType) {
        String headerName = "Language Ability - English, Evidence of";
        this.uploadDocument(headerName, documentType);
    }

    public void uploadQualifications(String documentType) {
        String headerName = "Qualifications - Overseas, Evidence of";
        this.uploadDocument(headerName, documentType);
    }
}
