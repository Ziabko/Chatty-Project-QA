import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAccountPage {

    private SelenideElement fillTheEmailRegistration = $("[name=\"email\"]");
    private SelenideElement fillThePasswordRegistration = $("[name=\"password\"]");
    private SelenideElement fillTheConfirmPasswordRegistration = $("[name=\"confirmPassword\"]");
    private SelenideElement selectAdminRegistration = $("[value=\"admin\"]");
    private SelenideElement selectUserRegistration =$("[value='user']");
    private SelenideElement registrationButton =$("[type=\"submit\"]");

    private SelenideElement errorMessageInvalidEmail =$(".text-error");
    private SelenideElement errorMessageInvalidPassword =$(".text-error");

    private SelenideElement errorMessageEmptyEmail =$x("//div[@class='text-error' and text()='Email cannot be empty']" );//text-error
    private SelenideElement errorMessageEmptyPassword =$x("//div[@class='text-error' and text()='Password cannot be empty']");////div[@class='text-error'][1]
    private SelenideElement errorMessageEmptyConfirmPassword =$x("//div[@class='text-error' and text()='Confirm password cannot be empty']");////div[@class='text-error'][1]

    private SelenideElement errorMessageInvalidConfirmPassword = $(".text-error");

    private SelenideElement dropdownSelect = $("select");
    private SelenideElement adminStatus = $("[value=\"admin\"]");




    public void enterUsername(String usernameValue) {
        fillTheEmailRegistration.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {fillThePasswordRegistration.setValue(passwordValue);}

    public void enterConfirmPassword(String passwordValue) {fillTheConfirmPasswordRegistration.setValue(passwordValue);}

    public void checkAdminSelect(){selectAdminRegistration.click();}

    public void checkUserSelect(){selectUserRegistration.click();}

    public void clickTheRegistrationButton(){registrationButton.click();}

    public void clearEmailField (){
        fillTheEmailRegistration.clear();
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
        fillThePasswordRegistration.clear();
    }

    public void clearConfirmPasswordFiled(){
        fillTheConfirmPasswordRegistration.clear();
    }

//    public void errorMessageTheInvalidConfirmPassword(String expectedErrorMessageConfirmPassword){
//        errorMessageInvalidConfirmPassword.shouldHave(text(expectedErrorMessageConfirmPassword));
//    }
    public void checkErrorMessageEmptyPassword(String expectedErrorMessageEmptyPassword) {
        errorMessageEmptyPassword.shouldHave(text(expectedErrorMessageEmptyPassword));
    }

        public void checkErrorMessageEmptyEmail(String expectedErrorMessageEmptyEmail){
            errorMessageEmptyEmail.shouldHave(text(expectedErrorMessageEmptyEmail));
        }

    public void checkErrorMessageEmptyConfirmPassword(String expectedErrorMessageEmptyConfirmPassword){
        errorMessageEmptyConfirmPassword.shouldHave(text(expectedErrorMessageEmptyConfirmPassword));
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




