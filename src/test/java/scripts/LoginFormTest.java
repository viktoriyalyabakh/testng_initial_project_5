package scripts;

import org.testng.annotations.BeforeMethod;
import pages.FrontendTestingHomePage;
import pages.LoginFormPage;

public class LoginFormTest extends Base{

   @BeforeMethod
   public void setPage(){
       frontendTestingHomePage = new FrontendTestingHomePage();
       loginFormPage = new LoginFormPage();
       frontendTestingHomePage.getFrontendTestingPage();
       frontendTestingHomePage.clickOnCard("Login Form");
   }

}
