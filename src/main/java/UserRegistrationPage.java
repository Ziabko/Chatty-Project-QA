import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class UserRegistrationPage {


    private SelenideElement editPlusIcon = $("[data-test=\"post-header__plus\"]");
    private SelenideElement userNameField = $("[name=\"name\"]");
    private SelenideElement userSurnameField = $("[name=\"surname\"]");
    private SelenideElement userBirthDateField = $("[name=\"birthDate\"]");
    private SelenideElement userPhoneField = $("[name=\"phone\"]");
    private SelenideElement dropDownGender = $("#gender");
    private SelenideElement saveButton = $(".save__btn");
    private SelenideElement usersAvatar = $(".upper-block input");
    private SelenideElement oldAvatar = $(".user_avatar_container__R0kVm img");


    public void clickEditPlusButton() {
        editPlusIcon.shouldBe(visible).click();
    }

    public void enterUserNameField(String userName) {
        userNameField.setValue(userName);
    }

    public void enterUserSurnameField(String userSurname) {
        userSurnameField.setValue(userSurname);
    }

    public void selectUserBirthDateField(String userBirthDate) {
        userBirthDateField.setValue(userBirthDate);
    }

    public void inputUserPhoneField(String userPhoneNumber) {
        userPhoneField.setValue(userPhoneNumber);
    }

    public void selectUserGender(String userGender) {
        dropDownGender.click();
        dropDownGender.selectOption(userGender);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void checkSaveButtonIsDisabled() {
        saveButton.shouldNotBe(enabled);
    }


    public void uploadUserAvatar(String imageFilePath) {
        usersAvatar.uploadFile(new File(imageFilePath));
    }

    public String getOldAvatarSrc() {
        return usersAvatar.getAttribute("src");
    }

    public void verifyAvatarSrcIsUpdated(String initialSrc) {
        oldAvatar.shouldNotHave(Condition.attribute("src", initialSrc));
    }

    public void clearUserName() {
        userNameField.clear();
    }


}

