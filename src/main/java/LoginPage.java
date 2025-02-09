import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameInputFiled = $("[name=\"email\"]");
    private SelenideElement passwordInputField = $(".input-password");
    private SelenideElement loginButton = $(".registration-btn");
    private SelenideElement errorMessageUsername = $(".text-error");
    private SelenideElement errorMessagePassword = $(".text-error");
    private SelenideElement loginFormTitle = $("h1");
    private SelenideElement eyeIcon = $(".password-eye");




    public void enterUsername(String usernameValue) {
        usernameInputFiled.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void checkErrorMessageUsername(String expectedErrorMessageUsername) {
        errorMessageUsername.shouldHave(text(expectedErrorMessageUsername));
    }

    public void checkErrorMessagePassword(String expectedErrorMessagePassword) {
        errorMessagePassword.shouldHave(text(expectedErrorMessagePassword));
    }

    public void clearUsername() {
        usernameInputFiled.clear();
    }

    public void clearPassword() {
        passwordInputField.clear();
    }

    public void checkLoginButtonDisabled() {
        loginButton.shouldNot(enabled);
    }

    public void checkLoginFormTitle(String expectedLoginFormTitle){
        loginFormTitle.shouldHave(text(expectedLoginFormTitle));
    }

    public void checkEyeIconIs() {
        eyeIcon.shouldBe(enabled);
    }
}





