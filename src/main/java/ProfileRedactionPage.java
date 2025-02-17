import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfileRedactionPage {


    private SelenideElement changePasswordButton =$(".pass__btn");
    private SelenideElement changeOldPasswordField =$("[placeholder=\"Old password\"]");
    private SelenideElement changeNewPasswordField =$("[placeholder=\"New password\"]");
    private SelenideElement changeConfirmNewPasswordField =$("[placeholder=\"Confirm new password\"]");
    private SelenideElement saveChangePasswordButton =$(".PasswordModal_pass_btn__eGL9h");
    private SelenideElement sidebarSectionName = $(".sidebar__section p");



    public void clickChangePasswordButton(){
        changePasswordButton.click();
    }
    public void checkChangeOldPasswordField(String ValueOldPassword){
        changeOldPasswordField.setValue(ValueOldPassword);
    }
    public void checkChangeNewPasswordField(String ValueNewPassword){
        changeNewPasswordField.setValue(ValueNewPassword);
    }
    public void checkChangeConfirmNewPasswordField(String ValueConfirmNewPassword){
        changeConfirmNewPasswordField.setValue(ValueConfirmNewPassword);
    }
    public void clickSaveChangePasswordButton(){
        saveChangePasswordButton.click();}

        public  void checkSidebarSectionName(String expectedName){
            sidebarSectionName.shouldBe(text(expectedName));
        }
    }





