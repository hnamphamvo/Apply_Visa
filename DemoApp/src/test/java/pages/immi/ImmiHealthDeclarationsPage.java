package pages.immi;

public class ImmiHealthDeclarationsPage extends GeneralPage {
    public void selectHealthDeclarations() {
        this.selectRadioButton01("last five years, has any applicant visited", "No");
        this.selectRadioButton01("applicant intend to enter a hospital", "No");
        this.selectRadioButton01("applicant intend to work as, or study or train to be", "No");
        this.selectRadioButton01("applicant intend to work, study or train within aged care", "No");
        this.selectRadioButton01("applicant intend to work or be a trainee at a child care centre", "No");
        this.selectRadioButton01("applicant intend to be in a classroom situation", "No");
        this.selectRadioButtonByLegend("Has any applicant:", "No");
        this.selectRadioButtonByLegend("applicant expect to incur medical costs, or require treatment", "No");
        this.selectRadioButton01("applicant require assistance with mobility", "No");
    }
}
