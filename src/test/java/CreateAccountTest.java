import org.junit.jupiter.api.Test;

public class CreateAccountTest extends BaseTest {

    //  *********    Id 131   Create user account with valid data(Stefan Martianov 10.02.2025) *******  Expected: Home page with title "Feed" is visible
    // +
    @Test
    public void validCreateUserAccount(){
        loginPage.clickOnSingUpButton();
        createAccountPage.enterUsername("base2111@gmail.com");
        createAccountPage.enterPassword("qwe123asd789");
        createAccountPage.enterConfirmPassword("qwe123asd789");
        createAccountPage.checkUserSelect();
        createAccountPage.clickTheRegistrationButton();
        createAccountPage.checkHomePageTitle("Feed");
    }

    //   ****** ID 132   Create account with invalid Email   *******  //  Expected: error message "Incorrect email format"
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

    // ****** ID 133   Create account with invalid Password  *******  //  Expected: error message "Password must be 8-100 characters and include at least one letter and one digit"
    // +
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

    //   ****** ID 134   Create account with empty Emai   *******  //  Expected: error message "Email cannot be empty", Registration button is disabled
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

    //   ****** ID 135   Create account with empty Password   *******  //  Expected: Registration button is disabled
    // +
    @Test
    public void createUserAccountWithEmptyPassword(){
        loginPage.clickOnSingUpButton();
        createAccountPage.enterUsername("zyablik20046778@ukr.net");
        createAccountPage.clearPasswordFiled();
        createAccountPage.checkUserSelect();
        createAccountPage.checkRegistrationButtonDisabled();
        createAccountPage.errorMessageTheInvalidPassword("Password cannot be empty");
      }

    //****** ID 136   Create account with empty Email and Password   *******  //  Expected: Registration button is disabled
    // +
    @Test
    public void createUserAccountWithEmptyEmailAndPassword(){
        loginPage.clickOnSingUpButton();
        createAccountPage.clearEmailField();
        createAccountPage.clearPasswordFiled();
        createAccountPage.clearConfirmPasswordFiled();
        createAccountPage.checkUserSelect();
        createAccountPage.checkRegistrationButtonDisabled();
       }

    //****** ID 137   Create account with empty Confirm Password   *******  //  Expected: Registration button is disabled
    // +
    @Test
    public void createAccountWithEmptyConfirmPassword(){
        loginPage.clickOnSingUpButton();
        createAccountPage.enterUsername("zyablik2004677877@ukr.net");
        createAccountPage.enterPassword("qwe1234asd789");
        createAccountPage.clearConfirmPasswordFiled();
        createAccountPage.checkUserSelect();
        createAccountPage.checkRegistrationButtonDisabled();
     }

    //****** ID 138   Create account with invalid confirm password   *******  //  Expected: error message "Passwords do not match"
    // +
    @Test
    public void createAccountWithInvalidConfirmPassword(){
        loginPage.clickOnSingUpButton();
        createAccountPage.enterUsername("Asdfg11@gmail.com");
        createAccountPage.enterPassword("Vbnm12345");
        createAccountPage.enterConfirmPassword("Vbnm1234567");
        createAccountPage.checkUserSelect();
        createAccountPage.checkErrorMessageInvalidConfirmPassword("Passwords do not match");
    }

    //****** ID 139  Possibility to select Admin status at registration (should not be)   *******  //  Admin status is not available
    // -
    @Test
    public void createAccountWithAdminStatus(){
        loginPage.clickOnSingUpButton();
        createAccountPage.clickDropdownSelect();
        createAccountPage.checkAdminStatus();
    }

    // check to create an account with an existing user.(Stefan Martianov - 12/02/2025)
    @Test public void createAccountWithExistUser(){
        loginPage.clickOnSingUpButton();
        createAccountPage.enterUsername("base2111@gmail.com");
        createAccountPage.enterPassword("qwe123asd789");
        createAccountPage.enterConfirmPassword("qwe123asd789");
        createAccountPage.checkUserSelect();
        createAccountPage.clickTheRegistrationButton();
        createAccountPage.alreadyExistsUsersTextError("Email already exists!");
    }

}
