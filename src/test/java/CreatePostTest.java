import com.codeborne.selenide.Condition;
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
}
