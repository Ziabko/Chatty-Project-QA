import org.junit.jupiter.api.Test;

public class ProfileRedactionTest extends BaseTest {

    @Test
    public void ProfilePasswordRedactionTest(){
        loginPage.successLogin("Mochalka1995@gmail.com", "barrel1995");
        header.selectYouProfilePage();
        userRegistrationPage.clickEditPlusButton();
        header.userProfileEntrance();
        profileRedactionPage.clickChangePasswordButton();
        profileRedactionPage.checkChangeOldPasswordField("barrel1995");
        profileRedactionPage.checkChangeNewPasswordField("barrel95");
        profileRedactionPage.checkChangeConfirmNewPasswordField("barrel95");
        profileRedactionPage.clickSaveChangePasswordButton();
        userRegistrationPage.clickSaveButton();
        header.selectLogoutProfile();
        loginPage.successLogin("Mochalka1995@gmail.com", "barrel95");
        homePage.checkHomePageTitle("Feed");

    }
}

