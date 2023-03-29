package tests;

import enums.ApplicationType;
import org.testng.annotations.Test;
import pages.immi.*;
import reporter.Reporter;
import utils.DataHelper;

import java.util.Map;

public class ImmiTest extends TestBase {
    ImmiTermsAndConditionsPage immiTermsAndConditionsPage = new ImmiTermsAndConditionsPage();
    ImmiApplicationContextPage immiApplicationContextPage = new ImmiApplicationContextPage();
    ImmiApplicantPage immiApplicantPage = new ImmiApplicantPage();
    ImmiCriticalDataConfirmationPage immiCriticalDataConfirmationPage = new ImmiCriticalDataConfirmationPage();
    ImmiAdditionalIdentityQuestionsPage immiAdditionalIdentityQuestionsPage = new ImmiAdditionalIdentityQuestionsPage();
    ImmiContactDetailsPage immiContactDetailsPage = new ImmiContactDetailsPage();
    ImmiAuthorisedRecipientPage immiAuthorisedRecipientPage = new ImmiAuthorisedRecipientPage();
    ImmiEducationPage immiEducationPage = new ImmiEducationPage();
    ImmiEducationHistoryPage immiEducationHistoryPage = new ImmiEducationHistoryPage();
    ImmiEmploymentPage immiEmploymentPage = new ImmiEmploymentPage();
    ImmiLanguagePage immiLanguagePage = new ImmiLanguagePage();
    ImmiHealthDeclarationsPage immiHealthDeclarationsPage = new ImmiHealthDeclarationsPage();
    ImmiCharacterDeclarationsPage immiCharacterDeclarationsPage = new ImmiCharacterDeclarationsPage();
    ImmiWorkHolidayDeclarationsPage immiWorkHolidayDeclarationsPage = new ImmiWorkHolidayDeclarationsPage();
    ImmiDeclarationsPage immiDeclarationsPage = new ImmiDeclarationsPage();
    ImmiReviewPage immiReviewPage = new ImmiReviewPage();
    ImmiAttachDocumentsPage immiAttachDocumentsPage = new ImmiAttachDocumentsPage();
    GeneralPage generalPage = new GeneralPage();

    @Test
    void Apply_Visa_462() {
        Map<String, String> data = DataHelper.loadDataFromClassName();

        Reporter.logTestStep("#1: Login to web application with provided credentials");
        new ImmiLoginPage().login(props.getProperty("cred.username"), props.getProperty("cred.password"));

        Reporter.logTestStep("#2: Go to List of applications");
        new ImmiLoginSuccessfulPage().goToApplication();
        boolean isApplicationExist = generalPage.checkApplicationExist();

        Reporter.logTestStep(" #3: Edit application");
        new ImmiApplicationsListPage().goToTermsAndConditions();

        Reporter.logTestStep("#4: Complete step 1 'Terms and Conditions'");
        immiTermsAndConditionsPage.agreeTermsAndConditions(isApplicationExist);
        immiTermsAndConditionsPage.goToNextPage();

        Reporter.logTestStep("#5: Complete step 2 'Application context'");
        immiApplicationContextPage.selectCurrentLocation("MALAYSIA", "Citizen");
//        immiApplicationContextPage.selectCurrentApplication(false, false);
        immiApplicationContextPage.selectApplicationType("First Work and Holiday visa (subclass 462)", false);
        immiApplicationContextPage.inputProposedArrivalDate("30 Sep 2023");
//        immiApplicationContextPage.selectGovernmentSupport(true);
        immiApplicationContextPage.goToNextPage();

        Reporter.logTestStep("#6: Complete step 3 'Applicant'");
        immiApplicantPage.fulfillPassportDetails("Nguyen", "Ki", "Female", "11 Nov 1996", "A30930309", "MALAYSIA - MYS", "MALAYSIA - MYS", "01 Jul 2010", "01 Jul 2030", "VIET NAM");
        immiApplicantPage.selectNationalIdentityCard("No");
        immiApplicantPage.fulfillPlaceOfBirth("Da Nang", "Da Nang", "VIETNAM");
        immiApplicantPage.selectRelationshipStatus("Married");
        immiApplicantPage.selectOtherInfo("No", "Yes", "No", "No", "No", "No");
        immiApplicantPage.goToNextPage();

        Reporter.logTestStep("#7: Complete step 4");
        immiCriticalDataConfirmationPage.confirmInformation("Yes");
        immiCriticalDataConfirmationPage.goToNextPage();

        Reporter.logTestStep("#8: Check Immi open");
        new GeneralPage().checkImmiOpen();

        Reporter.logTestStep("#9: Complete step 5");
        immiAdditionalIdentityQuestionsPage.selectPreviouslyAppliedVisa("No");
        immiAdditionalIdentityQuestionsPage.goToNextPage();

        Reporter.logTestStep("#10: Complete step 6");
        immiContactDetailsPage.selectCountryOfResidence("MALAYSIA");
        immiContactDetailsPage.selectDepartmentOffice("Malaysia, Kuala Lumpur");
        immiContactDetailsPage.fulfillResidentialAddress("MALAYSIA", "Address here", "Suburb here", "SABAH", "88000");
        immiContactDetailsPage.selectPostalAddress("Yes");
        immiContactDetailsPage.fulfillContactTelephoneNumber("600326933279");
        immiContactDetailsPage.goToNextPage();

        immiAuthorisedRecipientPage.selectAuthorisedPerson();
        immiAuthorisedRecipientPage.fulfillEmailAddress("Yes", "vipllaanhki16@gmail.com");
        immiAuthorisedRecipientPage.goToNextPage();

        immiEducationPage.selectMeetEducation();
        immiEducationPage.clickAddBTN();
        immiEducationHistoryPage.fulfillEducationHistory("Bachelor Degree (Other)", "Course A", "Institution B", "MALAYSIA", "13 Sep 2014", "13 Sep 2019", "Graduated");
        immiEducationHistoryPage.confirmForm();
        immiEducationPage.goToNextPage();

        immiEmploymentPage.fulFillEmployment("IT", "Other Services");
        immiEmploymentPage.goToNextPage();

        immiLanguagePage.selectLanguageOptions("No", "Yes", "1");
        immiLanguagePage.fulfillEnglishTestDetails("IELTS", "10 Nov 2022", "C32131321", "MALAYSIA", "Proficient");
        immiLanguagePage.selectMainLanguage("Malay");
        immiLanguagePage.goToNextPage();

        immiHealthDeclarationsPage.selectHealthDeclarations();
        immiHealthDeclarationsPage.goToNextPage();

        immiCharacterDeclarationsPage.selectCharacterDeclarations();
        immiCharacterDeclarationsPage.goToNextPage();

        immiWorkHolidayDeclarationsPage.selectWorkAndHolidayDeclarations();
        immiWorkHolidayDeclarationsPage.goToNextPage();

        immiDeclarationsPage.selectDeclarations();
        immiDeclarationsPage.goToNextPage();

        immiReviewPage.goToAttachPage();

        immiAttachDocumentsPage.uploadTravelDocument("E:\\Money2020\\Testing file\\Upload evidence\\DOCX sample (less than 10MB).docx", "Passport");
        immiAttachDocumentsPage.uploadPhotographPassport("Photograph - Passport");
        immiAttachDocumentsPage.uploadEvidenceOfFunds("Bank Statement - Personal");
        immiAttachDocumentsPage.uploadLanguageAbility("International English Language Testing System (IELTS)");
        immiAttachDocumentsPage.uploadQualifications("Educational Certificate (Degree, Diploma etc)");
    }
}
