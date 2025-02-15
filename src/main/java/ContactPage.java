import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {

    private SelenideElement contactPageTitle = $("h1");
    private SelenideElement userNameField = $("#name");
    private SelenideElement emailField = $("#email");
    private SelenideElement contentField = $("#content");
    private SelenideElement sendMessageButton = $("button");
    private SelenideElement successMessage = $(".success-message");

    public void checkContactPageTitle(String expectedTitle){
        contactPageTitle.shouldBe(visible).shouldHave(text(expectedTitle));
    }

    public void inputNameField(String name){
        userNameField.setValue(name);
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
    public void clearUserNameField() {
        userNameField.clear();
    }
    public void clearEmailField() {
        emailField.clear();
    }
    public void clearContentField() {
        contentField.clear();
    }
    public SelenideElement getErrorMessageEmptyNameField(String expectedErrorMessageEmptyName) {
        return userNameField.shouldHave(Condition.attribute("validationMessage", expectedErrorMessageEmptyName));
    }

    public SelenideElement getErrorMessageEmptyEmailField(String expectedErrorMessageEmptyEmail) {
        return emailField.shouldHave(Condition.attribute("validationMessage", expectedErrorMessageEmptyEmail));
    }

    public SelenideElement getErrorMessageEmptyContentField(String expectedErrorMessageEmptyContent) {
        return contentField.shouldHave(Condition.attribute("validationMessage", expectedErrorMessageEmptyContent));
    }




}
