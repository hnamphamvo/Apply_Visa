package pages.immi;

public class ImmiCharacterDeclarationsPage extends GeneralPage {
    public void selectCharacterDeclarations() {
        this.selectRadioButton01("applicant ever been charged with any offence", "No");
        this.selectRadioButton01("applicant ever been convicted of an offence", "No");
        this.selectRadioButton01("applicant ever been the subject of a domestic violence", "No");
        this.selectRadioButton01("applicant ever been the subject of an arrest warrant", "No");
        this.selectRadioButton01("applicant ever been found guilty of a sexually based offence", "No");
        this.selectRadioButton01("applicant ever been named on a sex offender", "No");
        this.selectRadioButton01("applicant ever been acquitted of any offence on the grounds", "No");
        this.selectRadioButton01("applicant ever been found by a court not fit to plead", "No");
        this.selectRadioButton01("applicant ever been directly or indirectly involved in", "No");
        this.selectRadioButton01("applicant ever been charged with, or indicted for: genocide", "No");
        this.selectRadioButton01("applicant ever been associated with a person, group or organisation", "No");
        this.selectRadioButton01("applicant ever been associated with an organisation", "No");
        this.selectRadioButton01("applicant ever served in a military force, police force", "No");
        this.selectRadioButton01("applicant ever undergone any military/paramilitary training", "No");
        this.selectRadioButton01("applicant ever been involved in people smuggling", "No");
        this.selectRadioButton01("applicant ever been removed, deported or excluded from any country", "No");
        this.selectRadioButton01("applicant ever overstayed a visa in any country", "No");
        this.selectRadioButton01("applicant ever had any outstanding debts to the Australian Government", "No");
    }
}
