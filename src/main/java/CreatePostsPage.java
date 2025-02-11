import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreatePostsPage {

    private SelenideElement createPostIcon = $("[data-test=\"post-header__plus\"]");
    private SelenideElement postTitleField = $("[name=\"title\"]");
    private SelenideElement postDescriptionField = $(".form-group:nth-child(2) .form-control ");
    private SelenideElement postСontentField = $("[name=\"content\"]");
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
        postСontentField.setValue(contentValidValue);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public void checkTitleOfCreatedPost(String expectedTitleOfCreatedPost) {
        titleOfCreatedPost.shouldHave(text(expectedTitleOfCreatedPost));
    }





// Stefan's changes 11.02

    private SelenideElement errorMessageEmptyTitle = $(".form-group:first-child .error");
    private SelenideElement errorMessageEmptyDescription = $x(".form-group:nth-child(2) .error");
    private SelenideElement errorMessageEmptyContent = $x("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[3]/p");



    public void titleErrorTextMessage(String expectedTitleErrorTextMessage){
        errorMessageEmptyTitle.shouldHave(text(expectedTitleErrorTextMessage));}

    public void descriptionErrorTextMessage(String expectedDescriptionErrorTextMessage){
        errorMessageEmptyDescription.shouldHave(text(expectedDescriptionErrorTextMessage));}

    public void contentTextMessage(String expectedContentErrorTextMessage){
        errorMessageEmptyContent.shouldHave(text(expectedContentErrorTextMessage));}

    public void clearDescriptionFiled(){
        postDescriptionField.clear();}

    public void clearContentFiled() {
        postСontentField.clear();
    }

    public void clearTitleFiled(){
        postTitleField.clear();
    }
    public void checkSubmitButtonDisabled() {
        submitButton.shouldNot(enabled);
    }



}
