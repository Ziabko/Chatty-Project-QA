import org.junit.jupiter.api.Test;

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
    }

