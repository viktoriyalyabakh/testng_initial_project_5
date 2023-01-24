package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FrontendTestingHomePage;
import pages.LoginFormPage;
import utilities.ConfigurationReader;

public class LoginFormTest extends Base{

   @BeforeMethod
   public void setPage(){
       frontendTestingHomePage = new FrontendTestingHomePage();
       loginFormPage = new LoginFormPage();
       frontendTestingHomePage.getFrontendTestingPage();
       frontendTestingHomePage.clickOnCard("Login Form");
   }

   /*
   Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    Then user should heading1 as “Login Form”
    And user should see “Please enter your username” label and username input box
    And user should see “Please enter your password” label and password input box
    And user should see “LOGIN” button
    And user should see “Forgot Password?” link
    */
   @Test(priority = 1, description = "Validate Tech Global login form card")
    public void validateLoginFormCard(){
       //validate heading1 as “Login Form”
       Assert.assertTrue(loginFormPage.mainHeader.isDisplayed());
       Assert.assertEquals(loginFormPage.mainHeader.getText(), "Login Form");

       //validate label text and visibility
       for(WebElement label: loginFormPage.labels){
           Assert.assertTrue(label.isDisplayed());
       }
       Assert.assertEquals(loginFormPage.labels.get(0).getText(), "Please enter your username");
       Assert.assertEquals(loginFormPage.labels.get(1).getText(), "Please enter your password");

       //validate input visible and enable
       for(WebElement input: loginFormPage.inputs){
           Assert.assertTrue(input.isDisplayed());
           Assert.assertTrue(input.isEnabled());
       }

       //validate login button
       Assert.assertTrue(loginFormPage.loginInButton.isDisplayed());
       Assert.assertTrue(loginFormPage.loginInButton.isEnabled());
       Assert.assertEquals(loginFormPage.loginInButton.getText(), "LOGIN");

       //validate forgot password link
       Assert.assertTrue(loginFormPage.forgotPasswordLink.isDisplayed());
       Assert.assertTrue(loginFormPage.forgotPasswordLink.isEnabled());
       Assert.assertEquals(loginFormPage.forgotPasswordLink.getText(), "Forgot Password?");
   }

   /*
   Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “You are logged in” message
    And user should see “LOGOUT” button
    */

    @Test(priority = 2, description = "Validate Tech Global login form card with valid login")
    public void validateLoginFormCardValidLogin(){
        //enter username and password
        loginFormPage.enterValidData("TechGlobal", "Test1234");

        //click login button
        loginFormPage.loginInButton.click();

        //validate success message and text
        Assert.assertTrue(loginFormPage.loginSuccessMessage.isDisplayed());
        Assert.assertEquals(loginFormPage.loginSuccessMessage.getText(), "You are logged in");

        //validate logout button is displayed
        Assert.assertTrue(loginFormPage.logoutButton.isDisplayed());

    }

    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    And user clicks on “LOGOUT” button
    Then user should be navigated back to Login Form
     */

    @Test(priority = 3, description = "Validate Tech Global login form card with valid login and logout")
    public void validateLoginFormCardValidLoginAnaLogout(){

        //enter username and password
        loginFormPage.enterValidData("TechGlobal", "Test1234");

        //click login button
        loginFormPage.loginInButton.click();

        //click logout button
        loginFormPage.logoutButton.click();

        //validate login button
        Assert.assertTrue(loginFormPage.loginInButton.isDisplayed());
    }

    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    Then user should see “Reset Password” heading1
    And user should see “Enter your email address and we'll send you a link to reset
    your password.” message
    And user should see email input box
    And user should see “SUBMIT” button
     */


    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    When user enters a valid email to email input box
    And user clicks on “SUBMIT” button
    Then user should see “A link to reset your password has been sent to your email
    address.” message
     */

    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
     */

    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Password entered!” message
     */

    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
     */

}
