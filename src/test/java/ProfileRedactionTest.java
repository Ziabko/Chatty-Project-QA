import org.junit.jupiter.api.Test;

public class ProfileRedactionTest extends BaseTest {

    //  **********  Editing your profile.   Change password.   ********* Expected: new password is saved, login is possible with the new password
    // +
    @Test
    public void profilePasswordRedactionTest(){
        String oldPassword = "barrel95";
        String newPassword = "barrel1995";
        loginPage.successLogin("Mochalka1995@gmail.com", oldPassword);
        header.userProfileEntrance();
        userRegistrationPage.clickEditPlusButton();
        profileRedactionPage.clickChangePasswordButton();
        profileRedactionPage.checkChangeOldPasswordField(oldPassword);
        profileRedactionPage.checkChangeNewPasswordField(newPassword);
        profileRedactionPage.checkChangeConfirmNewPasswordField(newPassword);
        profileRedactionPage.clickSaveChangePasswordButton();
        userRegistrationPage.clickSaveButton();
        header.userProfileEntrance();
        header.logoutYouProfile();
        loginPage.successLogin("Mochalka1995@gmail.com", newPassword);
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

