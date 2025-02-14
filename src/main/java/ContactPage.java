import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {

    private SelenideElement contactPageTitle = $("h1");
    private SelenideElement nameField = $("#name");
    private SelenideElement emailField = $("#email");
    private SelenideElement contentField = $("#content");
    private SelenideElement sendMessageButton = $("button");
    private SelenideElement successMessage = $(".success-message");

    public void checkContactPageTitle(String expectedTitle){
        contactPageTitle.shouldBe(visible).shouldHave(text(expectedTitle));
    }

    public void inputNameField(String name){
        nameField.setValue(name);
    }

    public void inputEmailField(String email){
        emailField.setValue(email);
    }

    public void inputContentField(String content){
        contentField.setValue(content);
    }

    public void clickSendMessageButton(){
        sendMessageButton.click();
    }
    public void checkSuccessMessage(String expectedSuccessMessage){
        successMessage.shouldHave(text(expectedSuccessMessage));
    }




}
