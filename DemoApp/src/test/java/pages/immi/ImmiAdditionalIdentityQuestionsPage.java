package pages.immi;

public class ImmiAdditionalIdentityQuestionsPage extends GeneralPage{
    public void selectPreviouslyAppliedVisa(String isApplied) {
        String label = "previously travelled to Australia or previously";
        if(isApplied.equals("Yes")) {
            this.selectRadioButton(label, "1");
        } else this.selectRadioButton(label, "2");
    }
}
