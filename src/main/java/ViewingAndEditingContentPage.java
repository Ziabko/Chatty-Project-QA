import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ViewingAndEditingContentPage {

    private SelenideElement penIcon = $(".edit-btns:first-child");
    private SelenideElement readingTimeText = $(".post-user__reading-time");
    private SelenideElement switchMyPostButton = $("[for=\"myPostsId\"]");
    private SelenideElement titleOfCreatedPost = $(".post-content__top h3")/*".post-content__top h3"*/;
    private SelenideElement selectMyPost = $(".post:first-child");
    private SelenideElement deletePostButton = $("[alt=\"delete button\"]");
    private SelenideElement editTitleField = $("[name=\"title\"]");
    private SelenideElement submitButtonEditPost = $("[data-test=\"submit\"]");



    public void clickPenIcon() {
        penIcon.click();
    }

    public void checkReadingTimeText(String expectedViewingPageReadingTimeText) {
        readingTimeText.shouldHave(text(expectedViewingPageReadingTimeText));
    }

    public void clickMyPostSwitch() {
        switchMyPostButton.shouldBe(visible).click();
    }

    public void selectMyUserPost() {
        selectMyPost.shouldBe(visible).click();
    }

    public void clickDeletePostButton() {
        deletePostButton.shouldBe(visible).click();
    }

    public String getDeletedPostTitle() {
        return titleOfCreatedPost.getText();
    }

    public void verifyDeletedPost(String oldH3) {
        titleOfCreatedPost.shouldBe(visible).shouldNotHave(Condition.text(oldH3));
    }

    public void clearTitleEditPost(){
        editTitleField.clear();
    }

    public void inputNewTitleEditPost(String newTitle){
        editTitleField.setValue(newTitle);
    }

    public void clickSubmitButtonEditPost(){
        submitButtonEditPost.click();
    }

    public void verifyEditedPost(String newTitle){
        titleOfCreatedPost.shouldBe(visible).shouldHave(Condition.text(newTitle));
    }


}

