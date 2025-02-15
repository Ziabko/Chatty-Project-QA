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
        sleep(3000);
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
        sleep(3000);
        contactPage.getErrorMessageEmptyContentField("Заполните это поле.");   // текст сообщения может меняться
    }


    }


