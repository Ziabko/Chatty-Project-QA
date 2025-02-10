import org.junit.jupiter.api.Test;

public class CreateAccountTest extends BaseTest {

    //Id 131   Create user account with valid data(Stefan Martianov 10.02.2025)//
    // +
    @Test
    public void validCreateUserAccount(){
        loginPage.clickOnSingUpButton();
        createAccountPage.enterUsername("base111@gmail.com");
        createAccountPage.enterPassword("qwe123asd789");
        createAccountPage.enterConfirmPassword("qwe123asd789");
        createAccountPage.checkUserSelect();
        createAccountPage.clickTheRegistrationButton();
    }

    //   ****** ID 132   Create account with invalid Email   *******  //  Expected: Incorrect email format
    // +
    @Test
    public void createUserAccountWithInvalidEmail(){
        loginPage.clickOnSingUpButton();
        createAccountPage.enterUsername("zyablik2004ukr.net");
        createAccountPage.enterPassword("qwe1234asd789");
        createAccountPage.enterConfirmPassword("qwe1234asd789");
        createAccountPage.checkUserSelect();
        createAccountPage.checkRegistrationButtonDisabled();
        createAccountPage.errorMessageInvalidEmail("Incorrect email format");

     }

    // ****** ID 133   Create account with invalid Email   *******  //  Expected: Password must be 8-100 characters and include at least one letter and one digit//
    @Test
    public void createUserAccountWithInvalidPassword(){
        loginPage.clickOnSingUpButton();
        createAccountPage.enterUsername("zyablik20046778@ukr.net");
        createAccountPage.enterPassword("asdfghjkla");
        createAccountPage.enterConfirmPassword("asdfghjkla");
        createAccountPage.checkUserSelect();
        createAccountPage.checkRegistrationButtonDisabled();
        createAccountPage.errorMessageTheInvalidPassword("Password must be 8-100 characters and include at least one letter and one digit");
    }

    //   ****** ID 134   Create account with empty Emai   *******  //  Expected: error message Email cannot be empty, Registration button is disabled
    // +
    @Test
    public void createUserAccountWithEmptyEmail(){
        loginPage.clickOnSingUpButton();
        createAccountPage.clearEmailField();
        createAccountPage.enterPassword("qwe1234asd789");
        createAccountPage.enterConfirmPassword("qwe1234asd789");
        createAccountPage.checkUserSelect();
        createAccountPage.checkRegistrationButtonDisabled();
        createAccountPage.errorMessageInvalidEmail("Email cannot be empty");

    }

}
