import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class UserRegistrationTest extends BaseTest{

    // ***** ID 82  User registration with valid data  ********

    @Test
    public void registrationWithValidData (){
        // String birthDateActivator = "g";
        loginPage.successLogin("user123@gmail.com", "userreg123");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.enterUserNameField("Julia");
        userRegistrationPage.enterUserSurnameField("Roberts");
        //userRegistrationPage.selectUserBirthDateField(birthDateActivator);
//      userRegistrationPage.clickUserBirthDateField();
        userRegistrationPage.selectUserBirthDateField("15.06.2000");
//        String selectedDate = userRegistrationPage.getUserBirthDateFieldValue();
//        System.out.println("Selected Birth Date: " + selectedDate);

        userRegistrationPage.inputUserPhoneField("123456789");
        userRegistrationPage.selectUserGender("MALE");
        userRegistrationPage.clickSaveButton();
        header.clickHomeLink();
        header.userProfileEntrance();
        userRegistrationPage.checkCreatedUserName("Julia");


        sleep(5000);

    }
}
