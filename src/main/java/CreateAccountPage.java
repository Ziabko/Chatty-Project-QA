import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateAccountPage {

    private SelenideElement emailInputField = $("[name=\"email\"]");
    private SelenideElement passwordInputField = $("[name=\"password\"]");
    private SelenideElement confirmPasswordInputField = $("[name=\"confirmPassword\"]");
    private SelenideElement selectUserStatus = $("[value='user']");
    private SelenideElement registrationButton = $("[type=\"submit\"]");
    private SelenideElement errorMessageInvalidEmail = $("div:nth-child(4)");
    private SelenideElement errorMessageInvalidPassword = $("div:nth-child(5)");
    private SelenideElement errorMessageInvalidConfirmPassword = $(".text-error");
    private SelenideElement dropdownSelect = $("select");
    private SelenideElement adminStatus = $("[value=\"admin\"]");
    private SelenideElement homePageTitle = $(".post-header__feed");
    private SelenideElement alreadyExistsUsersError = $(".container .text-error");

    public void createRandomUser(String usernameValue, String passwordValue, String confirmPasswordValue) {
        emailInputField.setValue(usernameValue);
        passwordInputField.setValue(passwordValue);
        confirmPasswordInputField.setValue(confirmPasswordValue);
        selectUserStatus.click();
        registrationButton.click();
    }

    public void enterUsername(String usernameValue) {
        emailInputField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }

    public void enterConfirmPassword(String passwordValue) {
        confirmPasswordInputField.setValue(passwordValue);
    }

    public void checkUserSelect() {
        selectUserStatus.click();
    }

    public void clickTheRegistrationButton() {
        registrationButton.click();
    }

    public void checkHomePageTitle(String expectedHomePageTitle) {
        homePageTitle.shouldBe(visible).shouldHave(text(expectedHomePageTitle));
    }

    public void clearEmailField() {
        emailInputField.clear();
    }

    public void checkRegistrationButtonDisabled() {
        registrationButton.shouldNot(enabled);
    }

    public void errorMessageInvalidEmail(String expectedErrorMessageEmail) {
        errorMessageInvalidEmail.shouldBe(visible).shouldHave(text(expectedErrorMessageEmail));
    }

    public void errorMessageTheInvalidPassword(String expectedErrorMessagePassword) {
        errorMessageInvalidPassword.shouldBe(visible).shouldHave(text(expectedErrorMessagePassword));
    }

    public void clearPasswordFiled() {
        passwordInputField.clear();
    }

    public void clearConfirmPasswordFiled() {
        confirmPasswordInputField.clear();
    }

    public void checkErrorMessageInvalidConfirmPassword(String expectedErrorMessage) {
        errorMessageInvalidConfirmPassword.shouldHave(text(expectedErrorMessage));
    }

    public void clickDropdownSelect() {
        dropdownSelect.click();
    }

    public void checkAdminStatus() {
        adminStatus.shouldNotBe(visible);
    }

    public void alreadyExistsUsersTextError(String expectedTextError) {
        alreadyExistsUsersError.shouldBe(visible).shouldHave(text(expectedTextError));
    }

}




