import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement usernameInputFiled = $("[name=\"email\"]");
    private SelenideElement passwordInputField = $(".input-password");
    private SelenideElement loginButton = $(".registration-btn");
    private SelenideElement errorMessageUsername = $(".text-error");
    private SelenideElement errorMessagePassword = $(".text-error");
    private SelenideElement loginFormTitle = $("h1");
    private SelenideElement signInLink = $x("//*[@id=\"root\"]/div/div/p/a");
    private SelenideElement singUpButton = $x("//*[@id=\"root\"]/div/div/form/p/a");
    private SelenideElement createAccountTitle = $x("//*[@id=\"root\"]/div/div/form/h1");


    public void enterUsername(String usernameValue) {
        usernameInputFiled.setValue(usernameValue);    }

    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void checkErrorMessageUsername(String expectedErrorMessageUsername) {
        errorMessageUsername.shouldHave(text(expectedErrorMessageUsername));    }

    public void checkErrorMessagePassword(String expectedErrorMessagePassword) {
        errorMessagePassword.shouldHave(text(expectedErrorMessagePassword));    }

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
        loginFormTitle.shouldHave(text(expectedLoginFormTitle));    }

    public void checkSignInLink() {
        signInLink.shouldNotBe(visible);
    }

    public void clickOnSingUpButton(){singUpButton.click();}

    public void checkCreateAccountMessage(String expectedCreateAccountText){
        createAccountTitle.shouldHave(text(expectedCreateAccountText));    }
}





