import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest{

   //  ******  Id 1. Autorization Admin. Valid data.  ********
    // +
    @Test
    public void successAdminLogin(){
       loginPage.enterUsername("zyablik2004@ukr.net");
       loginPage.enterPassword("AdminOlga1");
       loginPage.clickOnLoginButton();
       adminPanelPage.checkHeader("Admin panel");
    }

    //  ******  Id 35. Autorization User. Valid data.  ********
    // +
    @Test
    public  void  successUserLogin(){
        loginPage.enterUsername("Mochalka1995@gmail.com");
        loginPage.enterPassword("barrel1995");
        loginPage.clickOnLoginButton();
        homePage.checkHomePageTitle("Feed");
    }

    //  ******  Id 2, 36. Autorization User/Admin. Invalid username.  ********
    @Test
    public  void  invalidUsername(){
        loginPage.enterUsername("Mochalka@gmail.com");
        loginPage.enterPassword("barrel1995");
        loginPage.clickOnLoginButton();

    }
}
