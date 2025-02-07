import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameInputFiled = $("[name=\"email\"]");
    private SelenideElement passwordInputField = $(".input-password");
    private SelenideElement loginButton = $(".registration-btn");

    public void enterUsername(String usernameValue) {
        usernameInputFiled.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }
}
