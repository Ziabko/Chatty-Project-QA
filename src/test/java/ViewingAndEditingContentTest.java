import org.junit.jupiter.api.Test;

public class ViewingAndEditingContentTest extends BaseTest {


    // ***** ID 14  Viewing And Editing Content.  ********  Expected: Post viewing
    @Test
    public void viewingPostFeed() {
        loginPage.successLogin("Mochalka95@gmail.com", "barrel1995");
        header.clickHomeLink();
        homePage.checkHomePageTitle("Feed");
    }

    // ***** ID 16  Viewing And Editing Content. ********  Expected: Post selected and viewing
    @Test
    public void viewingAndSelectingPost() {
        loginPage.successLogin("Mochalka95@gmail.com", "barrel1995");
        header.clickHomeLink();
        homePage.checkPostSelect();
        viewingAndEditingContentPage.checkReadingTimeText("Reading time");

    }

    // ***** ID 66,19  Deleting your posts. ******* Expected: Post deleted.
    @Test
    public void deleteMyUserPost() {
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        viewingAndEditingContentPage.clickMyPostSwitch();
        String oldH3 = viewingAndEditingContentPage.getDeletedPostTitle();
        viewingAndEditingContentPage.selectMyUserPost();
        viewingAndEditingContentPage.clickDeletePostButton();
        viewingAndEditingContentPage.clickMyPostSwitch();
        viewingAndEditingContentPage.verifyDeletedPost(oldH3);

    }

    //  ********   Editing your posts (Edit title)  ********   Expected: Post edited
    // +
    @Test
    public void editMyUserPost() {
        String newTitle = "New title";
        loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
        viewingAndEditingContentPage.clickMyPostSwitch();
        viewingAndEditingContentPage.selectMyUserPost();
        viewingAndEditingContentPage.clickPenIcon();
        viewingAndEditingContentPage.clearTitleEditPost();
        viewingAndEditingContentPage.inputNewTitleEditPost(newTitle);
        viewingAndEditingContentPage.clickSubmitButtonEditPost();
        viewingAndEditingContentPage.verifyEditedPost(newTitle);


    }

}

