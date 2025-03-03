import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdminPanelPage {

    private SelenideElement adminPanelTitle = $("h1:first-child");
    private SelenideElement adminEmailSearchField = $("[placeholder=\"Search by email...\"]");
    private SelenideElement adminEmailSearchButton = $(".email-btn");
    private SelenideElement deleteUserButton = $x("//*[@id=\"root\"]/div[2]/div/div/table/tbody/tr[1]/td[5]/span[2]");
    private SelenideElement editUserButton = $("[data-test=\"editUserButton\"]");
    private SelenideElement foundEmail = $("[data-test=\"userEmail\"]");

    public void checkHeader(String expectedHeaderText) {
        adminPanelTitle.shouldBe(visible).shouldHave(text(expectedHeaderText));
    }

    public void inputEmailSearchField(String email) {
        adminEmailSearchField.setValue(email);
    }

    public void clickEmailSearchButton() {
        adminEmailSearchButton.shouldBe(visible).click();
    }

    public void clickDeleteUserButton() {
        deleteUserButton.click();
    }

    public void clickEditUserButton() {
        editUserButton.click();
    }

    public void checkNotFoundEmail() {
        foundEmail.shouldNotBe(visible);
    }

    public void checkFoundMail(String expectedEmailText) {
        foundEmail.shouldBe(visible).shouldHave(text(expectedEmailText));
    }


}


