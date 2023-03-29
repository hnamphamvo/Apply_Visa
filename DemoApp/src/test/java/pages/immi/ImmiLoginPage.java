package pages.immi;

import core.element.Button;
import core.element.TextBox;

public class ImmiLoginPage {
    private final TextBox txtUsername = new TextBox("//input[@name='username']");
    private final TextBox txtPassword = new TextBox("//input[@name='password']");
    private final Button btnLogin = new Button("//button[@name='login']");

    public void login(String username, String password) {
        this.txtUsername.sendKeys(username);
        this.txtPassword.sendKeys(password);
        this.btnLogin.click();
    }
}
