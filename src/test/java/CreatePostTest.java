import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.sleep;

public class CreatePostTest extends BaseTest{

//  *******  Creating a post with valid data in Title, Description, Content ********  Expected: The post saved
 // +
    @Test
    public void createPostUserWithValidData(){
        String expectedTitle = "Testing";
        loginPage.successLogin("z0667272624@gmail.com","UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(expectedTitle);
        createPostsPage.inputPostDescriptionField("Testing Description");
        createPostsPage.inputPostContentField("Testing theory");
        createPostsPage.clickSubmitButton();
        createPostsPage.checkTitleOfCreatedPost(expectedTitle);

    }

    //  ******* ID 115  Creating a post with valid data in Title, Content (with empty description) ********  Expected: The post saved
    // -
    @Test
    public void createPostUserWithEmptyDescription(){
        String expectedTitle = "Testing";
        loginPage.successLogin("z0667272624@gmail.com","UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(expectedTitle);
        createPostsPage.inputPostContentField("Testing theory");
        createPostsPage.clickSubmitButton();
        createPostsPage.checkTitleOfCreatedPost(expectedTitle);

    }

    //  ******* ID 116  Creating a post with invalid Title ********  Expected: Submit button is disable
    // -
    @Test
    public void createPostUserWithInvalidTitle(){
        String expectedTitle = "1";
        loginPage.successLogin("z0667272624@gmail.com","UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(expectedTitle);
        createPostsPage.inputPostDescriptionField("TestRun for QA");
        createPostsPage.inputPostContentField("Testing theory");
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 114  Creating a post with empty Title ********  Expected: Submit button is disable
    // -
    @Test
    public void createPostUserWithEmptyTitle(){
        loginPage.successLogin("z0667272624@gmail.com","UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.clearTitleFiled();
        createPostsPage.inputPostDescriptionField("TestRun for QA");
        createPostsPage.inputPostContentField("Testing theory");
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 117  Creating a post with empty Title, Content (with empty description) ********  Expected: Submit button is disable
    // -
    @Test
    public void createPostUserWithInvalidDescription(){
        loginPage.successLogin("z0667272624@gmail.com","UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField("WOOFmagic");
        createPostsPage.inputPostDescriptionField("s");
        createPostsPage.inputPostContentField("Testing theory");
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 118  Creating a post with empty Content ********  Expected: Submit button is disable
    // -
    @Test
    public void createPostUserWithEmptyContent(){
        loginPage.successLogin("z0667272624@gmail.com","UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField("WOOFmagic");
        createPostsPage.inputPostDescriptionField("The DogMaster");
        createPostsPage.clearContentFiled();
        createPostsPage.checkSubmitButtonDisabled();
    }

    //  ******* ID 123  Creating a post with 1001 symbol Content ********  Expected: Submit button is disable
    // -
    @Test
    public void createPostUserWith1001SymbolsContent(){
        String longText = "A".repeat(1001);
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField("WOOFmagic");
        createPostsPage.inputPostDescriptionField("The DogMaster");
        createPostsPage.inputPostContentField(longText);
        createPostsPage.checkSubmitButtonDisabled();
    }


    //  ******* ID 119  Creating a post with invalid image format (Size 3 Mb) ********  Expected: error message "Max size 2Mb
    // +
    @Test
    public void createPostUserWithBigImageSize () {
        String imagePath = "src/test/resourse/images/image3Mb.jpg";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField("Image big size");
        createPostsPage.inputPostDescriptionField("Image big size Description");
        createPostsPage.inputPostContentField("Image big size content");
        createPostsPage.uploadImage(imagePath);
        createPostsPage.checkErrorMessageUploadImage("File size exceeds the 2MB limit");

    }

    //  ******* ID 121  Creating a post with valid image format jpg  ********  Expected: home page is visible         что проверить ?
    // +
    @Test
    public void createPostUserWithValidImageJpg () {
        String imagePath = "src/test/resourse/images/smallimage.jpg";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField("Image big size");
        createPostsPage.inputPostDescriptionField("Image big size Description");
        createPostsPage.inputPostContentField("Image big size content");
        createPostsPage.uploadImage(imagePath);
        homePage.checkHomePageTitle("Feed");

    }

    //  ******* ID 125  Creating a post with valid image format (png)  ********  Expected: home page is visible    что проверить ?
    // +
    @Test
    public void createPostUserWithValidImagePng () {
        String imagePath = "src/test/resourse/images/png.png";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField("Image big size");
        createPostsPage.inputPostDescriptionField("Image big size Description");
        createPostsPage.inputPostContentField("Image big size content");
        createPostsPage.uploadImage(imagePath);
        homePage.checkHomePageTitle("Feed");

    }

    //  ******* ID 122  Creating a post with invalid image format (gif)  ********  Expected: error message
    // -
    @Test
    public void createPostUserWithInValidImageGif () {
        String imagePath = "src/test/resourse/images/gif.gif";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField("Image big size");
        createPostsPage.inputPostDescriptionField("Image big size Description");
        createPostsPage.inputPostContentField("Image big size content");
        createPostsPage.uploadImage(imagePath);
        homePage.checkHomePageTitle("Feed");
        createPostsPage.checkErrorMessageUploadImage("The image format should be only: jpg, jpeg, png");

    }










}





