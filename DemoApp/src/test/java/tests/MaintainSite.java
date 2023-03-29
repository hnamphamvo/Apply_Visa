package tests;

import org.testng.annotations.Test;
import pages.immi.*;
import reporter.Reporter;
import utils.DataHelper;

import java.util.Map;

public class MaintainSite extends TestBase {
    ImmiTermsAndConditionsPage immiTermsAndConditionsPage = new ImmiTermsAndConditionsPage();
    ImmiApplicationContextPage immiApplicationContextPage = new ImmiApplicationContextPage();
    ImmiApplicantPage immiApplicantPage = new ImmiApplicantPage();
    ImmiCriticalDataConfirmationPage immiCriticalDataConfirmationPage = new ImmiCriticalDataConfirmationPage();
    ImmiAdditionalIdentityQuestionsPage immiAdditionalIdentityQuestionsPage = new ImmiAdditionalIdentityQuestionsPage();
    ImmiContactDetailsPage immiContactDetailsPage = new ImmiContactDetailsPage();
    ImmiAuthorisedRecipientPage immiAuthorisedRecipientPage = new ImmiAuthorisedRecipientPage();
    ImmiEducationPage immiEducationPage = new ImmiEducationPage();
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
    void Maintain_Site() {
        Map<String, String> data = DataHelper.loadDataFromClassName();

        Reporter.logTestStep("#1: Login to web application with provided credentials");
        new ImmiLoginPage().login(props.getProperty("cred.usernameMaintain"), props.getProperty("cred.passwordMaintain"));

        Reporter.logTestStep("#2: Go to List of applications");
        new ImmiLoginSuccessfulPage().goToApplication();
        boolean isApplicationExist = generalPage.checkApplicationExist();

        Reporter.logTestStep("#3: Edit application");
        new ImmiApplicationsListPage().goToTermsAndConditions();

        Reporter.logTestStep("#4: Complete step 'Terms and Conditions'");
        immiTermsAndConditionsPage.agreeTermsAndConditions(isApplicationExist);
        immiTermsAndConditionsPage.goToNextPage();

        Reporter.logTestStep("#5: Complete step 'Application context'");
        immiApplicationContextPage.selectCurrentLocation(data.get("ACLocation"), data.get("ACStatus"));
        immiApplicationContextPage.selectCurrentApplication(data.get("ACDependentChildren"), data.get("ACSubclass417"));
        immiApplicationContextPage.selectApplicationType(data.get("ACApplicationType"), false);
        immiApplicationContextPage.inputProposedArrivalDate(data.get("ACProposedArrivalDate"));
        immiApplicationContextPage.selectGovernmentSupport(data.get("ACHaveLetter"));
        immiApplicationContextPage.goToNextPage();

        Reporter.logTestStep("#6: Complete step 'Applicant'");
        immiApplicantPage.fulfillPassportDetails(data.get("AFamilyName"), data.get("AGivenName"), data.get("ASexType"),
                data.get("ADateOfBirth"), data.get("APassportNum"), data.get("ACountryPassport"), data.get("ANationality"),
                data.get("ADateOfIssue"), data.get("ADateOfExpiry"), data.get("APlaceOfIssue"));
        immiApplicantPage.selectNationalIdentityCard(data.get("AHaveIdentityCard"));
        immiApplicantPage.fulfillPlaceOfBirth(data.get("ATownOrCity"), data.get("AStateOrProvince"), data.get("ACountryOfBirth"));
        immiApplicantPage.selectRelationshipStatus(data.get("ARelationshipStatus"));
        immiApplicantPage.selectOtherInfo(data.get("AHaveOtherName"), data.get("AIsCitizenOfSelectedCountryOfPP"),
                data.get("AIsCitizenOfOtherCountry"), data.get("AHaveOtherCurrentPP"), data.get("AHaveOtherIdentityDoc"),
                data.get("AHaveHealthExamIn12Months"));
        immiApplicantPage.fulfillReason(); //Only use for maintain purpose
        immiApplicantPage.goToNextPage();

        Reporter.logTestStep("#7: Complete step 'Critical Data Confirmation'");
        immiCriticalDataConfirmationPage.confirmInformation(data.get("CCIsInfoCorrect"));
        immiCriticalDataConfirmationPage.goToNextPage();

        Reporter.logTestStep("#8: Check Immi open");
        new GeneralPage().checkImmiOpen();

        Reporter.logTestStep("#9: Complete step 'Additional Identity Questions'");
        immiAdditionalIdentityQuestionsPage.selectPreviouslyAppliedVisa(data.get("AIQIsApplied"));
        immiAdditionalIdentityQuestionsPage.goToNextPage();

        Reporter.logTestStep("#10: Complete step 'Contact Details'");
        immiContactDetailsPage.selectCountryOfResidence(data.get("CDCountryOfResidence"));
        immiContactDetailsPage.selectDepartmentOffice(data.get("CDDepartmentOffice"));
        immiContactDetailsPage.fulfillResidentialAddress(data.get("CDCountry"), data.get("CDAddress"), data.get("CDSuburbOrTown"),
                data.get("CDStateOrProvince"), data.get("CDPostalCode"));
        immiContactDetailsPage.selectPostalAddress(data.get("CDIsTheSameResidentialAddress"));
        immiContactDetailsPage.fulfillContactTelephoneNumber(data.get("CDHomePhone"));
        immiContactDetailsPage.fulfillEmailAddress(data.get("CDIsRequired"), data.get("CDEmail"));
        immiContactDetailsPage.goToNextPage();

        Reporter.logTestStep("#11: Complete step 'Authorised Recipient'");
        immiAuthorisedRecipientPage.selectAuthorisedPerson();
        immiAuthorisedRecipientPage.fulfillEmailAddress(data.get("ARIsRequired"), data.get("AREmail"));
        immiAuthorisedRecipientPage.goToNextPage();

        Reporter.logTestStep("#12: Complete step 'Education'");
        immiEducationPage.selectMeetEducation();
        immiEducationPage.addEducation(data.get("EHQualification"), data.get("EHCourseName"),
                data.get("EHInstitutionName"), data.get("EHCountryOfInstitution"), data.get("EHDateFrom"),
                data.get("EHDateTo"), data.get("EHStatus"));
        immiEducationPage.goToNextPage();

        Reporter.logTestStep("#13: Complete step 'Employment'");
        immiEmploymentPage.fulFillEmployment(data.get("EUsualOccupation"), data.get("EIndustryType"));
        immiEmploymentPage.goToNextPage();

        Reporter.logTestStep("#14: Complete step 'Language'");
        immiLanguagePage.selectLanguageOptions(data.get("LIsEnglishCountry"), data.get("LHaveEnglishAbility"),
                data.get("LProofEnglish"));
        immiLanguagePage.fulfillEnglishTestDetails(data.get("LNameOfTest"), data.get("LDateOfTest"), data.get("LTestRN"),
                data.get("LCountryTest"), data.get("LLanguageAbility"));
        immiLanguagePage.selectMainLanguage(data.get("LMainLanguage"));
        immiLanguagePage.goToNextPage();

        Reporter.logTestStep("#15: Complete step 'Health Declarations'");
        immiHealthDeclarationsPage.selectHealthDeclarations();
        immiHealthDeclarationsPage.goToNextPage();

        Reporter.logTestStep("#16: Complete step 'Character Declarations'");
        immiCharacterDeclarationsPage.selectCharacterDeclarations();
        immiCharacterDeclarationsPage.goToNextPage();

        Reporter.logTestStep("#17: Complete step 'Work Holiday Declarations'");
        immiWorkHolidayDeclarationsPage.selectWorkAndHolidayDeclarations();
        immiWorkHolidayDeclarationsPage.goToNextPage();

        Reporter.logTestStep("#18: Complete step 'Declarations'");
        immiDeclarationsPage.selectDeclarations();
        immiDeclarationsPage.goToNextPage();

        Reporter.logTestStep("#19: Complete step 'Review'");
        immiReviewPage.goToAttachPage();

        Reporter.logTestStep("#20: Complete step 'Attach Documents'");
        immiAttachDocumentsPage.uploadTravelDocument(data.get("ADTravelDocumentType"));
        immiAttachDocumentsPage.uploadPhotographPassport(data.get("ADPhotographPassportType"));
        immiAttachDocumentsPage.uploadEvidenceOfFunds(data.get("ADEvidenceOfFundsType"));
        immiAttachDocumentsPage.uploadLanguageAbility(data.get("ADLanguageAbilityType"));
        immiAttachDocumentsPage.uploadQualifications(data.get("ADQualificationsType"));
    }
}
