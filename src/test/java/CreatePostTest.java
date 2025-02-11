import org.junit.jupiter.api.Test;

public class CreatePostTest extends BaseTest{

//  *******  Creating a post with valid data in Title, Description, Content ********  Expected: The post saved
 // +
    @Test
    public void createPostUserWithValidData(){
        String expectedTitle = "Testing";
        loginPage.enterUsername("z0667272624@gmail.com");
        loginPage.enterPassword("UserOlga1");
        loginPage.clickOnLoginButton();
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField(expectedTitle);
        createPostsPage.inputPostDescriptionField("Testing Description");
        createPostsPage.inputPostContentField("Testing theory");
        createPostsPage.clickSubmitButton();
        createPostsPage.checkTitleOfCreatedPost(expectedTitle);

    }

    //  ******* ID 115  Creating a post with valid data in Title, Content (with empty description) ********  Expected: The post saved

    @Test
    public void createPostUserWithEmtyDescription(){
        String expectedTitle = "Testing";
        loginPage.enterUsername("z0667272624@gmail.com");
        loginPage.enterPassword("UserOlga1");
        loginPage.clickOnLoginButton();
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
        loginPage.enterUsername("z0667272624@gmail.com");
        loginPage.enterPassword("UserOlga1");
        loginPage.clickOnLoginButton();
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
        loginPage.enterUsername("z0667272624@gmail.com");
        loginPage.enterPassword("UserOlga1");
        loginPage.clickOnLoginButton();
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
        loginPage.enterUsername("z0667272624@gmail.com");
        loginPage.enterPassword("UserOlga1");
        loginPage.clickOnLoginButton();
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
        loginPage.enterUsername("z0667272624@gmail.com");
        loginPage.enterPassword("UserOlga1");
        loginPage.clickOnLoginButton();
        createPostsPage.clickCreatePostIcon();
        createPostsPage.inputPostTitleField("WOOFmagic");
        createPostsPage.inputPostDescriptionField("The DogMaster");
        createPostsPage.clearContentFiled();
        createPostsPage.checkSubmitButtonDisabled();
    }
}





