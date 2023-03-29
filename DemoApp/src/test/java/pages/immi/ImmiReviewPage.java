package pages.immi;

import core.element.Button;

public class ImmiReviewPage extends GeneralPage {
    private final Button btnPageNext = new Button("//button[@title='Go to the next page']");

    public void goToAttachPage() {
        this.btnPageNext.click();
    }
}
