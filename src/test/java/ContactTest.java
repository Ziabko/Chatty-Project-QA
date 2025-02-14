import org.junit.jupiter.api.Test;

public class ContactTest extends BaseTest {

    // ******* ID 105   Feedback - Contact. Message wit valid date.  ********    Expected: message "Your message has been successfully submitted!"
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
}
