import org.junit.jupiter.api.Test;

public class ProfileRedactionTest extends BaseTest {

    //  **********  Editing your profile.   Change password.   ********* Expected: new password is saved, login is possible with the new password
    // +
    @Test
    public void profilePasswordRedactionTest(){
        loginPage.successLogin("Mochalka1995@gmail.com", "barrel1995");
//        header.selectYouProfilePage();
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        profileRedactionPage.clickChangePasswordButton();
        profileRedactionPage.checkChangeOldPasswordField("barrel1995");
        profileRedactionPage.checkChangeNewPasswordField("barrel95");
        profileRedactionPage.checkChangeConfirmNewPasswordField("barrel95");
        profileRedactionPage.clickSaveChangePasswordButton();
        userRegistrationPage.clickSaveButton();
        header.userProfileEntrance();
        header.selectLogoutProfile();
        loginPage.successLogin("Mochalka1995@gmail.com", "barrel95");
        homePage.checkHomePageTitle("Feed");
    }


    //  **********  Editing your profile.   Editing a profile with a name change   ********* Expected: profile saved
    // +
    @Test
    public void profileEditingTest(){
        String newName = "Lea";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        userRegistrationPage.clearUserName();
        userRegistrationPage.enterUserNameField(newName);
        userRegistrationPage.clickSaveButton();
        header.clickHomeLink();
        profileRedactionPage.checkSidebarSectionName(newName);
    }

}

