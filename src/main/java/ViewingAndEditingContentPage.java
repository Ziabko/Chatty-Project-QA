import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ViewingAndEditingContentPage {

        private SelenideElement penEditButton = $(".edit-btns");
        private SelenideElement readingTimeText = $(".post-user__reading-time");
        private SelenideElement switchMyPostButton = $("[for=\"myPostsId\"]");
        private SelenideElement titleOfCreatedPost = $(".post:first-child h3")/*".post-content__top h3"*/;
        private SelenideElement titleOfFirstPost =$x("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/h3");
        private SelenideElement selectMyPost = $x("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div/div[1]/div[1]");
        private SelenideElement deletePostButton =$("[alt=\"delete button\"]");

        public void clickEditButton(){penEditButton.click();}

        public void penEditButtonText(String expectedViewingPageUserEditButton){
            penEditButton.shouldHave(text(expectedViewingPageUserEditButton));
        }
        public void checkReadingTimeText(String expectedViewingPageReadingTimeText){
            readingTimeText.shouldHave(text(expectedViewingPageReadingTimeText));
        }
        public void clickMyPostSwitch(){
            switchMyPostButton.shouldBe(visible).click();
        }
         public void selectMyUserPost(){
            selectMyPost.shouldBe(visible).click();
            }
         public void clickDeletePostButton(){
            deletePostButton.shouldBe(visible).click();
             }

        public String getDeletedPostTitle() {return titleOfCreatedPost.getText();
        }
        public void verifyDeletedPost(String oldH3) {
            titleOfCreatedPost.shouldBe(visible).shouldNotHave(Condition.text(oldH3));
        }

    }

