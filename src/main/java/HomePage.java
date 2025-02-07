import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private SelenideElement homePageTitle = $( ".post-header__feed");

    public void checkHomePageTitle(String expectedTitleText){
        homePageTitle.shouldHave(text(expectedTitleText));
    }
}
