import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreatePostsPage {

    private SelenideElement createPostIcon = $("[data-test=\"post-header__plus\"]");
    private SelenideElement postTitleField = $("[name=\"title\"]");
    private SelenideElement postDescriptionField = $(".form-group:nth-child(2) .form-control ");
    private SelenideElement postcontentField = $("[name=\"content\"]");
    private SelenideElement submitButton = $("button");
    private SelenideElement titleOfCreatedPost = $(".post-content__top h3");




    public void clickCreatePostIcon(){
        createPostIcon.click();
    }
    public void inputPostTitleField(String titleValidValue){
        postTitleField.setValue(titleValidValue);
    }
    public void inputPostDescriptionField(String descriptionValidValue){
        postDescriptionField.setValue(descriptionValidValue);
    }
    public void inputPostContentField(String contentValidValue){
        postcontentField.setValue(contentValidValue);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public void checkTitleOfCreatedPost(String expectedTitleOfCreatedPost) {
        titleOfCreatedPost.shouldHave(Condition.text(expectedTitleOfCreatedPost));
    }



}
