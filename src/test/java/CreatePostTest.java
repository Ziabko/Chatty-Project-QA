import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePostTest extends BaseTest {

    Faker faker = new Faker();
    String titleRandom = faker.lorem().word();
    String descriptionRandom = faker.lorem().sentence();
    String contentRandom = faker.lorem().paragraph();

    //  *******  Creating a post with valid data in Title, Description, Content ********  Expected: The post saved
    // +
    @Test
    public void createPostUserWithValidData() {
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.clickSubmitButton();
        createPostsPage.checkTitleOfCreatedPost(titleRandom);

    }

    //  ******* ID 115  Creating a post with valid data in Title, Content (with empty description) ********  Expected: The post saved
    // -
    @Test
    public void createPostUserWithEmptyDescription() {
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.clickSubmitButton();
        createPostsPage.checkTitleOfCreatedPost(titleRandom);

    }

    //  ******* ID 116  Creating a post with invalid Title ********  Expected: Submit button is disabled
    // -
    @Test
    public void createPostUserWithInvalidTitle() {
        String expectedTitle = "1";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(expectedTitle);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 114  Creating a post with empty Title ********  Expected: Submit button is disabled
    // -
    @Test
    public void createPostUserWithEmptyTitle() {
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.clearTitleFiled();
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 117  Creating a post with empty Title, Content (with empty description) ********  Expected: Submit button is disabled
    // -
    @Test
    public void createPostUserWithInvalidDescription() {
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField("s");
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 118  Creating a post with empty Content ********  Expected: Submit button is disabled
    // -
    @Test
    public void createPostUserWithEmptyContent() {
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.clearContentFiled();
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 123  Creating a post with 1001 symbol Content ********  Expected: Submit button is disabled
    // -
    @Test
    public void createPostUserWith1001SymbolsContent() {
        String longText = "A" .repeat(1001);
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(longText);
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 120  Creating a post with Invalid deferred publication date ********  Expected: Submit button is disabled
    @Test
    public void createPostUserWithInvalidDeferredPublicationDate() {
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.inputDatePublishingPostField("13.02.2025");
        createPostsPage.checkSubmitButtonDisabled();
    }


    //  ******* ID 119  Creating a post with invalid image format (Size 3 Mb) ********  Expected: error message "Max size 2Mb
    // +
    @Test
    public void createPostUserWithBigImageSize() {
        String imagePath = "src/test/resourse/images/image3Mb.jpg";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.uploadImage(imagePath);
        createPostsPage.checkErrorMessageUploadImage("File size exceeds the 2MB limit");

    }

    //  ******* ID 121  Creating a post with valid image format jpg  ********  Expected: home page is visible
    // +
    @Test
    public void createPostUserWithValidImageJpg() {
        String imagePath = "src/test/resourse/images/smallimage.jpg";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.uploadImage(imagePath);
        createPostsPage.checkUploadedImage();

    }

    //  ******* ID 125  Creating a post with valid image format (png)  ********  Expected: home page is visible
    // +
    @Test
    public void createPostUserWithValidImagePng() {
        String imagePath = "src/test/resourse/images/png.png";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.uploadImage(imagePath);
        createPostsPage.checkUploadedImage();
    }

    //  ******* ID 122  Creating a post with invalid image format (gif)  ********  Expected: error message "The image format should be only: jpg, jpeg, png"
    // -
    @Test
    public void createPostUserWithInValidImageGif() {
        String imagePath = "src/test/resourse/images/gif.gif";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.uploadImage(imagePath);
        homePage.checkHomePageTitle("Feed");
        createPostsPage.checkErrorMessageUploadImage("The image format should be only: jpg, jpeg, png");

    }

    //  *******    Save post as a draft  ********  Expected: The created draft is in the list
    @Test
    public void CreatePostAsDraft() {
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(titleRandom);
        createPostsPage.inputPostDescriptionField(descriptionRandom);
        createPostsPage.inputPostContentField(contentRandom);
        createPostsPage.clickSaveADraftButton();
        createPostsPage.clickSubmitButton();
        createPostsPage.clickMyDraftButton();
        sleep(3000);
        List<String> draftTitles = createPostsPage.getAllDraftTitles();
        assertTrue(draftTitles.contains(titleRandom), "Created draft not found in list!");

    }
}





