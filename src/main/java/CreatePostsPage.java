import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CreatePostsPage {

    private SelenideElement createPostIcon = $("[data-test=\"post-header__plus\"]");
    private SelenideElement postTitleField = $("[name=\"title\"]");
    private SelenideElement postDescriptionField = $(".form-group:nth-child(2) .form-control ");
    private SelenideElement postСontentField = $("[name=\"content\"]");
    private SelenideElement submitButton = $("[data-test=\"submit\"]");
    private SelenideElement titleOfCreatedPost = $(".post:first-child  .post-content__top");

    private SelenideElement uploadImageField = $(".post_dropzone__TA6PN  input");
    private SelenideElement datePublishingPostField = $("#publishDate");
    private SelenideElement uploadedImage = $(".post_uploaded_image__7qSWV:first-child");
    private SelenideElement errorMessageUploadImage = $(".post_error_message__FQTrb");
    private SelenideElement saveDraftTumbler = $(".post-header__checkbox:nth-child(2)");

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

    private SelenideElement myDraftButton = $("[alt=\"Drafts\"]");

    public void clickSaveADraftButton() {
        saveDraftTumbler.shouldBe(visible).click();
    }

    public void clickMyDraftButton() {
        myDraftButton.shouldBe(visible).click();
    }

    public void checkTitleText(String expectedTitleOfCreatedPost) {
        titleOfCreatedPost.shouldBe(visible).shouldHave(text(expectedTitleOfCreatedPost));
    }

    public List<String> getAllDraftTitles() {
        return $$(".post-content__top h3")
                .texts(); // Получаем список текстов всех заголовков черновиков
    }
}






