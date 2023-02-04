package step;

import PageObjectModel.Login;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StepDefinitionsClass {

    Login login;
    WebDriver driver;

    @Given("User open browser")
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Given("open URL")
    public void open_url() {
        driver.get(BaseClass.baseUrl);
        driver.manage().window().maximize();
    }

    @When("check is Logo is displayed")
    public void check_is_logo_is_displayed() {
        login = new Login(driver);
        Assert.assertEquals(true, login.checkLogoPresent());
    }

    //    @When("User enter username and password")
//    public void user_enter_username_and_password() {
//        login.setUsername(BaseClass.validUsername);
//        login.setPassword(BaseClass.validPassword);
//    }
    @When("User enter username and password")
    public void user_enter_username_and_password() {
        login.setUsername(BaseClass.validUsername);
        login.setPassword(BaseClass.validPassword);
    }

    @When("click Submit button")
    public void click_submit_button() {
        login.clickSubmit();
    }

    @Then("check Log out button is displayed")
    public void check_log_out_button_is_displayed() {
        Assert.assertEquals(true, login.checkIfLoggInSuccessful());
    }

    //Scenario 2
    @When("User enter invalid username and password")
    public void user_enter_invalid_username_and_password() {
        login.setUsername(BaseClass.invalidUsername);
        login.setPassword(BaseClass.validPassword);
    }

    @Then("check is error for invalid username is displayed")
    public void check_is_error_for_invalid_username_is_displayed() {
        login = new Login(driver);
        Assert.assertEquals(true, login.checkIfInvalidUsername());
    }

    //Scenario 3
    @When("User enter username and invalid password")
    public void user_enter_username_and_invalid_password() {
        login.setUsername(BaseClass.validUsername);
        login.setPassword(BaseClass.invalidPassword);
    }
    @Then("check is error for invalid password is displayed")
    public void check_is_error_for_invalid_password_is_displayed() {
        login = new Login(driver);
        Assert.assertEquals(true,login.checkIfInvalidPassword());
    }

}
