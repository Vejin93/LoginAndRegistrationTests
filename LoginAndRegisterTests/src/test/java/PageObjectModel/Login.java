package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    //Parameters
    String logoPage = "//img[@alt='Practice Test Automation']";
    String fieldForUsername = "//input[@id='username']";
    String fieldForPassword = "//input[@id='password']";
    String buttonSubmit = "//button[@id='submit']";

    String buttonLogOut = "//a[normalize-space()='Log out']";

    String invalidUsernameOrPassword = "//div[@id='error']";

    public WebDriver driver;

    //Constructor
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By logoPageLocator = new By.ByXPath(logoPage);
    By fieldForUsernameLocator = new By.ByXPath(fieldForUsername);
    By fieldForPasswordLocator = new By.ByXPath(fieldForPassword);
    By buttonSubmitLocator = new By.ByXPath(buttonSubmit);
    By buttonLogOutLocator = new By.ByXPath(buttonLogOut);

    By invalidUsernameOrPasswordLocator = new By.ByXPath(invalidUsernameOrPassword);

    //Actions
    public boolean checkLogoPresent() {
        boolean status = driver.findElement(logoPageLocator).isDisplayed();
        return status;
    }

    public void setUsername(String username) {
        driver.findElement(fieldForUsernameLocator).clear();
        driver.findElement(fieldForUsernameLocator).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(fieldForPasswordLocator).clear();
        driver.findElement(fieldForPasswordLocator).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(buttonSubmitLocator).click();
    }

    public boolean checkIfLoggInSuccessful() {

        boolean status = driver.findElement(buttonLogOutLocator).isDisplayed();
        return status;
    }

    public boolean checkIfInvalidUsername()
    {
        boolean status = driver.findElement(invalidUsernameOrPasswordLocator).isDisplayed();
        return status;
    }

    public boolean checkIfInvalidPassword()
    {
        boolean status = driver.findElement(invalidUsernameOrPasswordLocator).isDisplayed();
        return status;
    }
}
