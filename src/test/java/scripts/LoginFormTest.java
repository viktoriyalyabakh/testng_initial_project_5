package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FrontendTestingHomePage;
import pages.LoginFormPage;
import pages.ResetPasswordPage;
import tastData.PageText;
import tastData.UserData;
import utilities.ConfigurationReader;
import utilities.Waiter;

public class LoginFormTest extends Base {

    @BeforeMethod
    public void setPage() {
        frontendTestingHomePage = new FrontendTestingHomePage();
        loginFormPage = new LoginFormPage();
        resetPasswordPage = new ResetPasswordPage();
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
    public void validateLoginFormCard() {
        //validate heading1 as “Login Form”
        Assert.assertTrue(loginFormPage.mainHeader.isDisplayed());
        Assert.assertEquals(loginFormPage.mainHeader.getText(), PageText.mainHeader);

        //validate label text and visibility
        loginFormPage.labels.forEach(c -> Assert.assertTrue(c.isDisplayed()));


        Assert.assertEquals(loginFormPage.labels.get(0).getText(), PageText.userNameInputLabel);
        Assert.assertEquals(loginFormPage.labels.get(1).getText(), PageText.passwordInputLabel);

        //validate input visible and enable
        loginFormPage.inputs.forEach(c -> {
            Assert.assertTrue(c.isDisplayed());
            Assert.assertTrue(c.isEnabled());
        });


        //validate login button
        Assert.assertTrue(loginFormPage.loginInButton.isDisplayed());
        Assert.assertTrue(loginFormPage.loginInButton.isEnabled());
        Assert.assertEquals(loginFormPage.loginInButton.getText(), PageText.loginInButton);

        //validate forgot password link
        Assert.assertTrue(loginFormPage.forgotPasswordLink.isDisplayed());
        Assert.assertTrue(loginFormPage.forgotPasswordLink.isEnabled());
        Assert.assertEquals(loginFormPage.forgotPasswordLink.getText(), PageText.forgotPasswordLink);
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
    public void validateLoginFormCardValidLogin() {
        //enter username and password
        loginFormPage.enterUsernameAndPassword("TechGlobal", "Test1234");

        //click login button
        loginFormPage.loginInButton.click();

        //validate success message and text
        Assert.assertTrue(loginFormPage.loginSuccessMessage.isDisplayed());
        Assert.assertEquals(loginFormPage.loginSuccessMessage.getText(), PageText.loginSuccessMessage);

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
    public void validateLoginFormCardValidLoginAnaLogout() {

        //enter username and password
        loginFormPage.enterUsernameAndPassword(UserData.validUsername, UserData.validPassword);

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

    @Test(priority = 4, description = "Validate Tech Global forgot password link")
    public void validateForgotPasswordLink() {
        //clock forgot password link
        loginFormPage.forgotPasswordLink.click();

        //validate heading reset password
        Assert.assertTrue(resetPasswordPage.headingResetPassword.isDisplayed());

        //validate reset password message text and it`s visible
        Assert.assertTrue(resetPasswordPage.resetPasswordLabel.isDisplayed());
        Assert.assertEquals(resetPasswordPage.resetPasswordLabel.getText(), PageText.resetPasswordLabel);

        //validate email input
        Assert.assertTrue(resetPasswordPage.emailInput.isDisplayed());

        //validate Submit button
        Assert.assertTrue(resetPasswordPage.submitButton.isDisplayed());

    }


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

    @Test(priority = 5, description = "Validate reset password link message displayed")
    public void validateResetLinkIsDisplayed() {

        loginFormPage.forgotPasswordLink.click();

        //enter email in reset password input
        resetPasswordPage.emailInput.sendKeys("email@gmail.com");
        resetPasswordPage.submitButton.click();

        Assert.assertTrue(resetPasswordPage.confirmationMessage.isDisplayed());
    }

    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
     */

    @Test(priority = 6, description = "Validate Tech Global login form with wrong username")
    public void validateLoginFormWithWrongUsername() {

        //enter invalid username and valid password
        loginFormPage.enterUsernameAndPassword(UserData.invalidUsername, UserData.validPassword);
        loginFormPage.loginInButton.click();

        //validate error message
        Assert.assertTrue(loginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginFormPage.errorMessage.getText(), PageText.invalidUsernameMessage);

    }
    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Password entered!” message
     */

    @Test(priority = 7, description = "Validate Tech Global login form with wrong password")
    public void validateLoginFormWithWrongPassword() {

        //enter valid username and invalid password
        loginFormPage.enterUsernameAndPassword(UserData.validUsername, UserData.invalidPassword);
        loginFormPage.loginInButton.click();

        //validate error message
        Assert.assertTrue(loginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginFormPage.errorMessage.getText(), PageText.invalidPasswordMessage);
    }
    /*
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
     */

        @Test(priority = 8, description = "Validate Tech Global login form with wrong user name and password")
        public void validateLoginFormWithWrongUsernameAndPassword() {

            //enter invalid username and invalid password
            loginFormPage.enterUsernameAndPassword(UserData.invalidUsername, UserData.invalidPassword);
            loginFormPage.loginInButton.click();

            //validate error message
            Assert.assertTrue(loginFormPage.errorMessage.isDisplayed());
            Assert.assertEquals(loginFormPage.errorMessage.getText(), PageText.invalidUsernameMessage);
        }
        }



