import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private SelenideElement homePageTitle = $( ".post-header__feed");
    private SelenideElement homePageUserName = $(".sidebar__section div:nth-child(1) p");
    private SelenideElement homePagePostSelect =$(".post:first-child");

    public void checkHomePageTitle(String expectedTitleText){
        homePageTitle.shouldHave(text(expectedTitleText));
    }

    public void checkHomePageUserName(String expectedHomePageUserName){
        homePageUserName.shouldHave(text(expectedHomePageUserName));
    }

    public void checkPostSelect(){
        homePagePostSelect.click();
    }
}
