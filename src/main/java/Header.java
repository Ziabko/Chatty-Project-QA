import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    private SelenideElement helloUser = $(".header__user");
    private SelenideElement logoutUserProfil = $("a[href=\"/login\"]");
    private SelenideElement userProfile = $("a[href=\"/userprofile\"]");
    private SelenideElement homeLink = $(".header__nav-list li:first-child");


    public  void selectYouProfilePage (){
        helloUser.click();
        logoutUserProfil.click();
    }
    public void userProfileEntrance (){
        helloUser.click();
        userProfile.click();
    }
    public void clickHomeLink(){
        homeLink.click();
    }
    public void checkCreatedUserName(String expectedUserName){
        helloUser.shouldHave(Condition.value(expectedUserName));
    }

}
