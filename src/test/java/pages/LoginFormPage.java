package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

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

    @FindBy(id = "success_lgn")
    public WebElement loginSuccessMessage;

    @FindBy(id = "logout")
    public WebElement logoutButton;

    public void enterValidData(String username, String password){
        inputs.get(0).sendKeys(username);
        inputs.get(1).sendKeys(password);
    }




}
