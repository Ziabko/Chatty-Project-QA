import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AdminPanelPage {

    private SelenideElement adminPanelTitle = $("h1:first-child");

    public void checkHeader(String expectedHeaderText){
        adminPanelTitle.shouldHave(text(expectedHeaderText));
    }



}
