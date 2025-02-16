import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ContactTest extends BaseTest {

    // ******* ID 105   Feedback - Contact. Send message wit valid date.  ********    Expected: message "Your message has been successfully submitted!"
    // +
    @Test
    public void createContactMessageWithValidDate(){
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.clickContactLink();
        contactPage.checkContactPageTitle("Contact Us");
        contactPage.inputNameField("Olga");
        contactPage.inputEmailField("z0667272624@gmail.com");
        contactPage.inputContentField("Suggestions for site improvements");
        contactPage.clickSendMessageButton();
        contactPage.checkSuccessMessage("Feedback submitted successfully!");

    }

    // ******* ID 106   Feedback - Contact. Send message wit empty name  ********    Expected: message "This field must not be empty"
    // +
    @Test
    public void createContactMessageWithEmptyName(){
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.clickContactLink();
        contactPage.checkContactPageTitle("Contact Us");
        contactPage.clearUserNameField();
        contactPage.inputEmailField("z0667272624@gmail.com");
        contactPage.inputContentField("Suggestions for site improvements");
        contactPage.clickSendMessageButton();
        contactPage.getErrorMessageEmptyNameField("Заполните это поле.");   // текст сообщения может меняться
    }

   // ******* ID 107   Feedback - Contact. Send message wit empty email  ********    Expected: message "This field must not be empty"
    // +
    @Test
    public void createContactMessageWithEmptyEmail(){
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.clickContactLink();
        contactPage.checkContactPageTitle("Contact Us");
        contactPage.inputNameField("Olga");
        contactPage.clearEmailField();
        contactPage.inputContentField("Suggestions for site improvements");
        contactPage.clickSendMessageButton();
        contactPage.getErrorMessageEmptyEmailField("Заполните это поле.");   // текст сообщения может меняться
    }

    // ******* ID 108   Feedback - Contact. Send message wit empty content  ********    Expected: message "This field must not be empty"
    // +

    @Test
    public void createContactMessageWithEmptyContent(){
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.clickContactLink();
        contactPage.checkContactPageTitle("Contact Us");
        contactPage.inputNameField("Olga");
        contactPage.inputEmailField("z0667272624@gmail.com");
        contactPage.clearContentField();
        contactPage.clickSendMessageButton();
        contactPage.getErrorMessageEmptyContentField("Заполните это поле.");   // текст сообщения может меняться
    }

    // ******* ID 109   Feedback - Contact. Send message wit invalid email (without @)  ********    Expected: error message "Invalid email format"
    // +
    @Test
    public void createContactMessageWithInvalidEmailWithoutAt(){
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.clickContactLink();
        contactPage.checkContactPageTitle("Contact Us");
        contactPage.inputNameField("Olga");
        contactPage.inputEmailField("z0667272624gmail.com");
        contactPage.getErrorMessageInvalidEmailWithoutAt("Invalid email format");

    }

    // ******* ID 110   Feedback - Contact. Send message wit invalid name (more than 30 symbols)  ********  Expected: the successfully submitted message is not visible
    // -
    @Test
    public void createContactMessageWithInvalidName(){
        String longTextName = "A".repeat(32);
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.clickContactLink();
        contactPage.checkContactPageTitle("Contact Us");
        contactPage.inputNameField(longTextName);
        contactPage.inputEmailField("z0667272624@gmail.com");
        contactPage.inputContentField("Suggestions for site improvements");
        contactPage.clickSendMessageButton();
        contactPage.checkSuccessMessage("Feedback submitted successfully!");
    }

    // ******* ID 111   Feedback - Contact. Send message wit invalid content (more than 1000 symbols)  ********  Expected: the successfully submitted message is not visible
    // +
    @Test
    public void createContactMessageWithInvalidContentLang(){
        String longTextContent = "A".repeat(1001);
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.clickContactLink();
        contactPage.checkContactPageTitle("Contact Us");
        contactPage.inputNameField("Olga");
        contactPage.inputEmailField("z0667272624@gmail.com");
        contactPage.inputContentField(longTextContent);
        contactPage.clickSendMessageButton();
        contactPage.checkSuccessMessage("Feedback submitted successfully!");
    }

    // ******* ID 113   Feedback - Contact. Send message wit invalid content (more than 1000 symbols)  ********  Expected: the successfully submitted message is not visible
    // -
    @Test
    public void createContactMessageWithInvalidContentShort(){
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        header.clickContactLink();
        contactPage.checkContactPageTitle("Contact Us");
        contactPage.inputNameField("Olga");
        contactPage.inputEmailField("z0667272624@gmail.com");
        contactPage.inputContentField("fr");
        contactPage.clickSendMessageButton();
        contactPage.checkSuccessMessage("Feedback submitted successfully!");
    }



    }


