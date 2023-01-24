package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.FrontendTestingHomePage;
import pages.LoginFormPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Base {
    WebDriver driver;
    BasePage basePage;
    FrontendTestingHomePage frontendTestingHomePage;
    LoginFormPage loginFormPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        basePage = new BasePage();
        driver.get(ConfigurationReader.getProperty("appUrl"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
