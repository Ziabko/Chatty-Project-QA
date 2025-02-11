import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateAccountPage {

    private SelenideElement emailInputField = $("[name=\"email\"]");
    private SelenideElement passwordInputField = $("[name=\"password\"]");
    private SelenideElement confirmPasswordInputField = $("[name=\"confirmPassword\"]");
    private SelenideElement selectAdminStatus = $("[value=\"admin\"]");
    private SelenideElement selectUserStatus =$("[value='user']");
    private SelenideElement registrationButton =$("[type=\"submit\"]");

    private SelenideElement errorMessageInvalidEmail =$(".text-error");
    private SelenideElement errorMessageInvalidPassword =$(".text-error");
    private SelenideElement errorMessageInvalidConfirmPassword = $(".text-error");

    private SelenideElement dropdownSelect = $("select");
    private SelenideElement adminStatus = $("[value=\"admin\"]");




    public void enterUsername(String usernameValue) {
        emailInputField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);}

    public void enterConfirmPassword(String passwordValue) {
        confirmPasswordInputField.setValue(passwordValue);}

    public void checkAdminSelect(){
        selectAdminStatus.click();}

    public void checkUserSelect(){
        selectUserStatus.click();}

    public void clickTheRegistrationButton(){registrationButton.click();}

    public void clearEmailField (){
        emailInputField.clear();
    }
    public void checkRegistrationButtonDisabled() {
        registrationButton.shouldNot(enabled);
    }
    public void errorMessageInvalidEmail(String expectedErrorMessageEmail) {
        errorMessageInvalidEmail.shouldHave(text(expectedErrorMessageEmail));
    }

    public void errorMessageTheInvalidPassword(String expectedErrorMessagePassword){
        errorMessageInvalidPassword.shouldHave(text(expectedErrorMessagePassword));
    }

    public void clearPasswordFiled(){
        passwordInputField.clear();
    }

    public void clearConfirmPasswordFiled(){
        confirmPasswordInputField.clear();
    }


    public  void checkErrorMessageInvalidConfirmPassword(String expectedErrorMessageImvalidConfirmPassword){
        errorMessageInvalidConfirmPassword.shouldHave(text(expectedErrorMessageImvalidConfirmPassword));
    }

    public void clickDropdownSelect (){
        dropdownSelect.click();
    }
    public  void checkAdminStatus(){
        adminStatus.shouldNotBe(visible);
    }

    }




