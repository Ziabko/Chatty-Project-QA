import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UserRegistrationPage {

    private SelenideElement personalInformationTitle = $(".post-header__feed");
    private SelenideElement editPlusIcon = $("[data-test=\"post-header__plus\"]");
    private SelenideElement userNameField = $("[name=\"name\"]");
    private SelenideElement userSurnameField = $("[name=\"surname\"]");
    private SelenideElement userBirthDateField = $("[name=\"birthDate\"]");
    private SelenideElement userPhoneField = $("[name=\"phone\"]");
    private SelenideElement changePasswordButton = $(".pass__btn");
    private SelenideElement dropDownGender = $("#gender");
    private SelenideElement saveButton = $(".save__btn");
    private SelenideElement usersAvatar = $(".user_uploaded_image__JubbD");

    public void clickEditPlusButton(){
        editPlusIcon.click();
    }
    public void enterUserNameField(String userName){
        userNameField.setValue(userName);
    }
    public void enterUserSurnameField(String userSurname){
        userSurnameField.setValue(userSurname);
    }
    public void selectUserBirthDateField(String userBirthDate){
        userBirthDateField.setValue(userBirthDate);
    }
    public void activateBirthDateField(String birthDateFieldActiv){
        userBirthDateField.setValue(birthDateFieldActiv);
    }
    public String getUserBirthDateFieldValue() {
        return userBirthDateField.getValue();
    }
    public void clickUserBirthDateField(){
        userBirthDateField.click();
    }
    public void inputUserPhoneField(String userPhoneNumber){
        userPhoneField.setValue(userPhoneNumber);
    }
    public void selectUserGender(String userGender){
        dropDownGender.click();
        dropDownGender.selectOption(userGender);
    }
    public  void clickSaveButton(){
        saveButton.click();
    }
    public void checkCreatedUserName(String expectedUserName){
        userNameField.shouldHave(text(expectedUserName));
    }










}
