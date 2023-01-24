package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends BasePage{

    public ResetPasswordPage(){
        super();
    }
    @FindBy(id = "sub_heading")
    public WebElement headingResetPassword;

    @FindBy(css = "label[for='email']")
    public WebElement resetPasswordLabel;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "confirmation_message")
    public WebElement confirmationMessage;

}
