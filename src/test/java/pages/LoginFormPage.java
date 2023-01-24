package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginFormPage extends BasePage{

    public LoginFormPage(){
        super();
    }

   @FindBy(id = "main_heading")
    public WebElement mainHeader;

    @FindBy(css = ".LoginForm_form__b4o6J label")
    public List<WebElement> labels;

    @FindBy(css = ".LoginForm_form__b4o6J input")
    public List<WebElement> inputs;

    @FindBy(id = "login_btn")
    public WebElement loginInButton;

    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordLink;




}
