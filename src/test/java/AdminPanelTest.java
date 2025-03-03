import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminPanelTest  extends BaseTest {
    Faker faker = new Faker();
    String userEmail = faker.internet().emailAddress();
    String userPassword = faker.internet().password();

    @Test
    public void deleteAccountUserAsAAdmin(){
        loginPage.clickOnSingUpButton();
        createAccountPage.createRandomUser(userEmail, userPassword, userPassword);
        header.logoutYouProfile();
        loginPage.successLogin("Mochalka95@gmail.com", "barrel1995");
        adminPanelPage.inputEmailSearchField(userEmail);
        adminPanelPage.clickEmailSearchButton();
        adminPanelPage.clickDeleteUserButton();
        adminPanelPage.inputEmailSearchField(userEmail);
        adminPanelPage.clickEmailSearchButton();
        adminPanelPage.checkNotFoundEmail();
    }

    @Test
    public void successSearchUserAsAAdmin(){
        loginPage.clickOnSingUpButton();
        createAccountPage.createRandomUser(userEmail, userPassword, userPassword);
        header.logoutYouProfile();
        loginPage.successLogin("Mochalka95@gmail.com", "barrel1995");
        adminPanelPage.inputEmailSearchField(userEmail);
        adminPanelPage.clickEmailSearchButton();
        adminPanelPage.checkFoundMail(userEmail);
    }

    @Test
    public void unsuccessfulSearchUserAsAAdmin(){
        loginPage.clickOnSingUpButton();
        createAccountPage.createRandomUser(1 + userEmail, userPassword, userPassword);
        header.logoutYouProfile();
        loginPage.successLogin("Mochalka95@gmail.com", "barrel1995");
        adminPanelPage.inputEmailSearchField(userEmail);
        adminPanelPage.clickEmailSearchButton();
        adminPanelPage.checkNotFoundEmail();
    }


}

