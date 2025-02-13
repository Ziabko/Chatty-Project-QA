import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class UserRegistrationTest extends BaseTest {

    // ***** ID 82  User registration with valid data  ********
    // +
    @Test
    public void userRegistrationWithValidData() {
        String userName = "Julia";
        loginPage.successLogin("user123@gmail.com", "userreg123");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserNameField(userName);
        userRegistrationPage.enterUserSurnameField("Roberts");
        userRegistrationPage.selectUserBirthDateField("15.06.2000");
        userRegistrationPage.inputUserPhoneField("123456789");
        userRegistrationPage.selectUserGender("MALE");
        userRegistrationPage.clickSaveButton();
        header.clickHomeLink();
        homePage.checkHomePageUserName(userName);
    }

    // ***** ID 84  User registration with empty Phone  ********  Expected: save button is not enabled
    // -
    @Test
    public void userRegistrationWithEmptyPhone() {
        loginPage.successLogin("benaffleck@gmail.com", "benaffleck123");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserNameField("Benny");
        userRegistrationPage.enterUserSurnameField("Affleck");
        userRegistrationPage.selectUserBirthDateField("15.08.2000");
        userRegistrationPage.inputUserPhoneField("321456987");
        userRegistrationPage.selectUserGender("MALE");
        userRegistrationPage.checkSaveButtonIsDisabled();
    }

    // ***** ID 85  User registration with empty Name  ********  Expected: save button is not enabled
    // -
    @Test
    public void userRegistrationWithEmptyName() {
        loginPage.successLogin("chan@gmail.com", "chan1234");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserSurnameField("Chan");
        userRegistrationPage.selectUserBirthDateField("11.08.2000");
        userRegistrationPage.inputUserPhoneField("321456967");
        userRegistrationPage.selectUserGender("MALE");
        userRegistrationPage.checkSaveButtonIsDisabled();
    }

    // ***** ID 89  User registration with invalid Birthdate (User under 7 years old)  ********  Expected: save button is not enabled
    // -
    @Test
    public void userRegistrationWithInvalidBirthdate() {
        loginPage.successLogin("chan@gmail.com", "chan1234");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserNameField("Jacky");
        userRegistrationPage.enterUserSurnameField("Chan");
        userRegistrationPage.selectUserBirthDateField("11.08.2020");
        userRegistrationPage.inputUserPhoneField("321456967");
        userRegistrationPage.selectUserGender("MALE");
        userRegistrationPage.checkSaveButtonIsDisabled();
    }

    // ***** ID 91  User registration with invalid name (2 symbols)  ********  Expected: save button is not enabled
    // -
    @Test
    public void userRegistrationWithInvalidName() {
        loginPage.successLogin("chan@gmail.com", "chan1234");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserNameField("Ja");
        userRegistrationPage.enterUserSurnameField("Chan");
        userRegistrationPage.selectUserBirthDateField("11.08.2020");
        userRegistrationPage.inputUserPhoneField("321456967");
        userRegistrationPage.selectUserGender("MALE");
        userRegistrationPage.checkSaveButtonIsDisabled();
    }

    // ***** ID 93  User registration with empty surname  ********  Expected: save button is not enabled
    // -
    @Test
    public void userRegistrationWithEmptySurname() {
        loginPage.successLogin("chan@gmail.com", "chan1234");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserNameField("Jacky");
        userRegistrationPage.selectUserBirthDateField("11.08.2020");
        userRegistrationPage.inputUserPhoneField("321456967");
        userRegistrationPage.selectUserGender("MALE");
        userRegistrationPage.checkSaveButtonIsDisabled();
    }

    // ***** ID 94  User registration with invalid surname (2 symbols)  ********  Expected: save button is not enabled
    // -
    @Test
    public void userRegistrationWithInvalidSurname() {
        loginPage.successLogin("arnold@gmail.com", "arnold123");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserNameField("Arny");
        userRegistrationPage.enterUserSurnameField("Sc");
        userRegistrationPage.selectUserBirthDateField("11.08.2020");
        userRegistrationPage.inputUserPhoneField("321456967");
        userRegistrationPage.selectUserGender("MALE");
        userRegistrationPage.checkSaveButtonIsDisabled();
    }

    // ***** ID 99  User registration with unselected gender  ********  Expected: save button is not enabled
    // -
    @Test
    public void userRegistrationWithUnselectedGender() {
        loginPage.successLogin("arnold@gmail.com", "arnold123");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserNameField("Arny");
        userRegistrationPage.enterUserSurnameField("Scwarz");
        userRegistrationPage.selectUserBirthDateField("11.08.2020");
        userRegistrationPage.inputUserPhoneField("321456967");
        userRegistrationPage.checkSaveButtonIsDisabled();
    }

    // ***** ID 140  User registration. Upload avatar photo  ********  Expected: Avatar photo uploaded      как проверить, что картинка загружена?
    @Test
    public void uploadAvatarPhoto(){
        String imagePath = "src/test/resourse/images/smallimage.jpg";
        loginPage.successLogin("benaffleck@gmail.com", "benaffleck123");
        sleep(3000);
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.uploadUserAvatar(imagePath);
//        userRegistrationPage.uploadedAvatarImageIsVisible();
//        userRegistrationPage.checkUploadedAvatarSrc("smallimage.jpg");

    }

    }




