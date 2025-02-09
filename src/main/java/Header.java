import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    private SelenideElement helloUser = $(".header__user");
    private SelenideElement logoutUerProfil = $("a[href=\"/login\"]");

    private SelenideElement userProfile = $("a[href=\"/userprofile\"]");


    public  void selectYouProfilePage (){
        helloUser.click();
        logoutUerProfil.click();
    }
}
