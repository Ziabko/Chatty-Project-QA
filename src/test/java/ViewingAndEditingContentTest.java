import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ViewingAndEditingContentTest extends BaseTest{


        // ***** ID 14  Viewing And Editing Content.  ********  Expected: Post viewing
        @Test
        public void viewingPostFeed(){
            loginPage.successLogin("Mochalka95@gmail.com", "barrel1995");
            header.clickHomeLink();
            homePage.checkHomePageTitle("Feed");
        }

        // ***** ID 16  Viewing And Editing Content. ********  Expected: Post was be select and viewing
        @Test
        public void viewingAndSelectingPost(){
            loginPage.successLogin("Mochalka95@gmail.com", "barrel1995");
            header.clickHomeLink();
            homePage.checkPostSelect();
            viewingAndEditingContentPage.checkReadingTimeText("Reading time");

        }

        // ***** ID 66,19  Deleting your posts. Expected: Post was be deleted.
        @Test
        public void DeleteMyUserPost(){
            loginPage.successLogin("z0667272624@gmail.com", "UserOlga1");
            viewingAndEditingContentPage.clickMyPostSwitch();
            String oldH3 = viewingAndEditingContentPage.getDeletedPostTitle();
            viewingAndEditingContentPage.selectMyUserPost();
            viewingAndEditingContentPage.clickDeletePostButton();
            sleep(3000);
            viewingAndEditingContentPage.clickMyPostSwitch();
            sleep(3000);
            viewingAndEditingContentPage.verifyDeletedPost(oldH3);

        }
    }

