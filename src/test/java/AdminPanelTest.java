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
//    String invalidField = faker.lorem().word();
    String phoneNumber = faker.number().digits(9);
    String name = faker.name().firstName();
    String surname = faker.name().lastName();
    Date birthDate = faker.date().birthday(8, 100);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    String formattedDate = dateFormat.format(birthDate);

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

//    @Test
//    public void createUserAsAAdmin(){
//      loginPage.clickOnSingUpButton();
//      createAccountPage.createRandomUser(userEmail, userPassword, userPassword);
//      header.logoutYouProfile();
//      loginPage.successLogin("zyablik2004@ukr.net", "AdminOlga1");
//      adminPanelPage.inputEmailSearchField(userEmail);
//        sleep(3000);
//      adminPanelPage.clickEmailSearchButton();
//        sleep(3000);
//      adminPanelPage.clickEditUserButton();
//      sleep(3000);
//      userRegistrationPage.clickEditPlusButton();
//      userRegistrationPage.createRandomUserInformation(name, surname, "MALE", "", "");
//
//    }

}

