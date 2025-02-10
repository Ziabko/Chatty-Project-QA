
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginTest extends BaseTest {


    //  ******  Id 1. Authorization Admin. Valid data.  ********
    // +
    @Test
    public void successAdminLogin() {
        loginPage.enterUsername("zyablik2004@ukr.net");
        loginPage.enterPassword("AdminOlga1");
        loginPage.clickOnLoginButton();
        adminPanelPage.checkHeader("Admin panel");
    }

    //  ******  Id 35. Authorization User. Valid data.  ********
    // +
    @Test
    public void successUserLogin() {
        loginPage.enterUsername("Mochalka1995@gmail.com");
        loginPage.enterPassword("barrel1995");
        loginPage.clickOnLoginButton();
        homePage.checkHomePageTitle("Feed");
    }

    //  ******  Id 2, 36. Authorization User/Admin. Invalid username.  ********
    // -
    @Test
    public void invalidUsername() {
        loginPage.enterUsername("Mochalka@gmail.com");
        loginPage.enterPassword("barrel1995");
        loginPage.clickOnLoginButton();
        loginPage.checkErrorMessageUsername("Incorrect user name or password");
    }

//  ******  Id 3, 37. Authorization User/Admin. Invalid Password.  ******** Expected: error message "incorrect username or password"
    // -
    @Test
    public void invalidPassword() {
        loginPage.enterUsername("Mochalka95@gmail.com");
        loginPage.enterPassword("barrel199576");
        loginPage.clickOnLoginButton();
        loginPage.checkErrorMessagePassword("Incorrect username or password");
    }

       //  ******  Id 23, 38. Authorization User/Admin. empty Username.  ******** Expected: Login button is disabled
       // +
    @Test
    public void emptyUsername(){
        loginPage.clearUsername();
        loginPage.enterPassword("barrel1995");
        loginPage.checkLoginButtonDisabled();
    }

    //  ******  Id 6, 39. Authorization User/Admin. empty Password.  ********  Expected: Login button is disabled
    // -
    @Test
    public void emptyPassword(){
        loginPage.enterUsername("Mochalka95@gmail.com");
        loginPage.clearPassword();
        loginPage.checkLoginButtonDisabled();
    }

    //  ******  Id 7, 40. Authorization User/Admin. empty Password.  ********  Expected: Login button is disabled
    // +
    @Test
    public void emptyLoginAndPassword(){
        loginPage.clearUsername();
        loginPage.clearPassword();
        loginPage.checkLoginButtonDisabled();
    }

    //  ******  Id 127/129 Logout Admin and user  ********  Expected: Login form on Login page
    // +
    @Test
    public void accountLogoutAdminUser(){
        loginPage.enterUsername("Mochalka1995@gmail.com");
        loginPage.enterPassword("barrel1995");
        loginPage.clickOnLoginButton();
        header.selectYouProfilePage();
       loginPage.checkLoginFormTitle("Login Form");
    }

    //   ******  Sign in link on Login page should not be visible  ******* Expected: Sign in link is not visible
    //
    @Test
    public void checkSignInLinkIsNotVisible(){
       loginPage.checkSignInLink();
    }






}
