package pages.immi;

public class ImmiWorkHolidayDeclarationsPage extends GeneralPage {
    public void selectWorkAndHolidayDeclarations() {
        this.selectRadioButton01("Understand that they must abide by the conditions of the visa", "Yes");
        this.selectRadioButton01("one employer for more than 6 months", "Yes");
        this.selectRadioButton01("undertake studies or training for more than 4 months", "Yes");
        this.selectRadioButton01("Have sufficient funds for the initial period", "Yes");
        this.selectRadioButton01("Understand that any employment is incidental", "Yes");
    }
}
