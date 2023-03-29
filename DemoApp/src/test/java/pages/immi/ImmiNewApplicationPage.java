package pages.immi;

import core.element.Button;

public class ImmiNewApplicationPage extends GeneralPage {
    private final Button btnWHM = new Button("(//span[text()='Working Holiday Maker']/ancestor::button)[1]");
    private final Button btnWHV462 = new Button("(//span[text()='Work and Holiday Visa (462)']/ancestor::button)[1]");

    public void selectWorkingHolidayVisa() {
        this.btnWHM.click();
        this.btnWHV462.click();
    }
}
