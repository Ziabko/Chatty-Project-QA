import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    private SelenideElement helloUser = $(".header__user");
    private SelenideElement logoutUserProfil = $("a[href=\"/login\"]");
    private SelenideElement userProfile = $("a[href=\"/userprofile\"]");
    private SelenideElement homeLink = $(".header__nav-list li:first-child");
    private SelenideElement contactLink = $(".header__nav-list li:nth-child(3)");


    public void logoutYouProfile() {
        helloUser.click();
        logoutUserProfil.click();
    }

    public void userProfileEntrance() {
        helloUser.shouldBe(visible).click();
        userProfile.shouldBe(visible).click();
    }

    public void clickHomeLink() {
        homeLink.shouldBe(visible).click();
    }

    public void clickContactLink() {
        contactLink.click();
    }

}
