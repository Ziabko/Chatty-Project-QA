import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

    public class ViewingAndEditingContentPage {

        private SelenideElement penEditButton = $(".edit-btns");
        private SelenideElement readingTimeText = $(".post-user__reading-time");
        private SelenideElement switchMyPostButton = $("[for=\"myPostsId\"]");

        public void clickEditButton(){penEditButton.click();}

        public void penEditButtonText(String expectedViewingPageUserEditButton){
            penEditButton.shouldHave(text(expectedViewingPageUserEditButton));
        }
        public void checkReadingTimeText(String expectedViewingPageReadingTimeText){
            readingTimeText.shouldHave(text(expectedViewingPageReadingTimeText));
        }
        public void clickMyPostSwitch(){switchMyPostButton.click();
        }
    }

