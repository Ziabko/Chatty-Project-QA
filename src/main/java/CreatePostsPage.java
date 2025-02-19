import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreatePostsPage {

    private SelenideElement createPostIcon = $("[data-test=\"post-header__plus\"]");
    private SelenideElement postTitleField = $("[name=\"title\"]");
    private SelenideElement postDescriptionField = $(".form-group:nth-child(2) .form-control ");
    private SelenideElement postСontentField = $("[name=\"content\"]");
    private SelenideElement submitButton = $("button");
    private SelenideElement titleOfCreatedPost = $(".post-content__top h3");  //          ????????????????????????????????????????????? проверить и поменять

    private SelenideElement uploadImageField = $(".post_dropzone__TA6PN  input");
    private SelenideElement datePublishingPostField = $("#publishDate");
    private SelenideElement uploadedImage = $(".post_uploaded_image__7qSWV:first-child");
    private SelenideElement errorMessageUploadImage = $(".post_error_message__FQTrb");
    private SelenideElement saveDraftTumbler = $("#draftCheckbox");

//    private SelenideElement errorMessageEmptyTitle = $(".form-group:first-child .error");
//    private SelenideElement errorMessageEmptyDescription = $x(".form-group:nth-child(2) .error");
//    private SelenideElement errorMessageEmptyContent = $x("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[3]/p");


    public void clickCreatePostIcon() {
        createPostIcon.shouldBe(visible).click();
    }

    public void inputPostTitleField(String titleValidValue) {
        postTitleField.setValue(titleValidValue);
    }

    public void inputPostDescriptionField(String descriptionValidValue) {
        postDescriptionField.setValue(descriptionValidValue);
    }

    public void inputPostContentField(String contentValidValue) {
        postСontentField.setValue(contentValidValue);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void checkTitleOfCreatedPost(String expectedTitleOfCreatedPost) {
        titleOfCreatedPost.shouldBe(visible).shouldHave(text(expectedTitleOfCreatedPost));
    }

    //    public void titleErrorTextMessage(String expectedTitleErrorTextMessage){
//        errorMessageEmptyTitle.shouldHave(text(expectedTitleErrorTextMessage));
//    }
//    public void descriptionErrorTextMessage(String expectedDescriptionErrorTextMessage){
//        errorMessageEmptyDescription.shouldHave(text(expectedDescriptionErrorTextMessage));
//    }
//    public void contentTextMessage(String expectedContentErrorTextMessage){
//        errorMessageEmptyContent.shouldHave(text(expectedContentErrorTextMessage));
//    }
//    public void clearDescriptionFiled(){
//        postDescriptionField.clear();
//    }
    public void clearContentFiled() {
        postСontentField.clear();
    }

    public void clearTitleFiled() {
        postTitleField.clear();
    }

    public void checkSubmitButtonDisabled() {
        submitButton.shouldNot(enabled);
    }

    public void inputDatePublishingPostField(String yesterdayDate) {
        datePublishingPostField.setValue(yesterdayDate);
    }

    public void uploadImage(String imageFilePath) {
        uploadImageField.uploadFile(new java.io.File(imageFilePath));
    }

    public void checkUploadedImage() {
        uploadedImage.shouldHave(attributeMatching("src", ".+"));
    }

    public void checkErrorMessageUploadImage(String expectedErrorMessage) {
        errorMessageUploadImage.shouldHave(text(expectedErrorMessage));
    }

    public void clickSaveDraftTumbler(){
        saveDraftTumbler.click();
    }

}






