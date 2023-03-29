package pages.immi;

public class ImmiEmploymentPage extends GeneralPage{
    public void fulFillEmployment(String usualOccupation, String industryType){
        this.fulfillTextBox("Usual occupation", usualOccupation);
        this.selectDDLByLabel("Industry type", industryType);
    }
}
