import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeEach
    public void setUo() {
        Configuration.timeout = 10000;
//      Configuration.headless = true;
        open("http://chatty.telran-edu.de:8089/login");
    }

    LoginPage loginPage = new LoginPage();
    AdminPanelPage adminPanelPage = new AdminPanelPage();
    HomePage homePage = new HomePage();
    Header header = new Header();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    CreatePostsPage createPostsPage = new CreatePostsPage();
    UserRegistrationPage userRegistrationPage = new UserRegistrationPage();


}
