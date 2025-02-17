
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {


    //  ******  Id 1. Authorization Admin. Valid data.  ********
    // +
    @Test
    public void successAdminLogin() {
        loginPage.successLogin("zyablik2004@ukr.net","AdminOlga1");
        adminPanelPage.checkHeader("Admin panel");
    }

    //  ******  Id 35. Authorization User. Valid data.  ********
    // +
    @Test
    public void successUserLogin() {
        loginPage.successLogin("Mochalka1995@gmail.com","barrel1995");
        homePage.checkHomePageTitle("Feed");
    }

    //  ******  Id 2, 36. Authorization User/Admin. Invalid username.  ********  Expected: error message "Incorrect username or password"
    // -
    @Test
    public void invalidUsername() {
        loginPage.successLogin("Mochalka@gmail.com","barrel1995");
        loginPage.checkErrorMessageUsername("Incorrect username or password");
    }

//  ******  Id 3, 37. Authorization User/Admin. Invalid Password.  ******** Expected: error message "incorrect username or password"
    // -
    @Test
    public void invalidPassword() {
        loginPage.successLogin("Mochalka1995@gmail.com","barr1995");
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
        loginPage.successLogin("Mochalka1995@gmail.com","barrel1995");
        header.logoutYouProfile();
       loginPage.checkLoginFormTitle("Login Form");
    }

    //   ******  Sign in link on Login page should not be visible  ******* Expected: Sign in link is not visible
    //
    @Test
    public void checkSignInLinkIsNotVisible(){
       loginPage.checkSignInLink();
    }






}
