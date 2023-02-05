package step;

import PageObjectModel.Login;
import PageObjectModel.Registration;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StepDefinitionsClass {

    Login login;
    WebDriver driver;
    Registration registration;

    @Given("User open browser")
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Given("open URL")
    public void open_url() {
        driver.get(MockDataClass.baseUrlLogin);
        driver.manage().window().maximize();
    }

    @When("check is Logo is displayed")
    public void check_is_logo_is_displayed() {
        login = new Login(driver);
        Assert.assertEquals(true, login.checkLogoPresent());
    }

    @When("User enter username and password")
    public void user_enter_username_and_password() {
        login.setUsername(MockDataClass.validUsernameLogin);
        login.setPassword(MockDataClass.validPasswordLogin);
    }

    @When("click Submit button")
    public void click_submit_button() {
        login.clickSubmit();
    }

    @Then("check Log out button is displayed")
    public void check_log_out_button_is_displayed() {
        login = new Login(driver);
        Assert.assertEquals(true, login.checkIfLoggInSuccessful());
    }

    //Scenario 2
    @When("User enter invalid username and password")
    public void user_enter_invalid_username_and_password() {
        login.setUsername(MockDataClass.invalidUsernameLogin);
        login.setPassword(MockDataClass.validPasswordLogin);
    }

    @Then("check is error for invalid username is displayed")
    public void check_is_error_for_invalid_username_is_displayed() {
        login = new Login(driver);
        Assert.assertEquals(true, login.checkIfInvalidUsername());
    }

    //Scenario 3
    @When("User enter username and invalid password")
    public void user_enter_username_and_invalid_password() {
        login.setUsername(MockDataClass.validUsernameLogin);
        login.setPassword(MockDataClass.invalidPasswordLogin);
    }

    @Then("check is error for invalid password is displayed")
    public void check_is_error_for_invalid_password_is_displayed() {
        login = new Login(driver);
        Assert.assertEquals(true, login.checkIfInvalidPassword());
    }


    // Registration
    @Given("User open browser for registration")
    public void user_open_browser_for_registration() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("open URL for registration")
    public void open_url_for_registration() {
        driver.get(MockDataClass.baseUrlRegister);
        driver.manage().window().maximize();
    }

    @When("check is Logo is displayed on home page")
    public void check_is_logo_is_displayed_on_home_page() {
        registration = new Registration(driver);
        Assert.assertEquals(true, registration.checkLogoPresentOnRegistrationPage());
    }

    @When("click on Register href on header")
    public void click_on_register_href_on_header() {
        registration.clickOnRegisterHrefOnHeader();
    }

    @When("check if Registration page")
    public void check_if_registration_page() {
        Assert.assertEquals(true, registration.checkRegisterPage());
    }

    @When("User enter data for registration")
    public void user_enter_data_for_registration() {
        registration.setGender(MockDataClass.maleGender);

        registration.setFirstName(MockDataClass.firstName);
        registration.setLastName(MockDataClass.lastName);

        registration.setDayOfBirth(MockDataClass.dayOfBirth);
        registration.setMonthOfBirth(MockDataClass.monthOfBirth);
        registration.setYearOfBirth(MockDataClass.yearOfBirth);

        registration.setEmail(MockDataClass.email);

        registration.setCompanyName(MockDataClass.companyName);

        registration.setNewsletterBox(MockDataClass.newsletter);

        registration.setPassword(MockDataClass.password);
        registration.setConfirmPassword(MockDataClass.password);
    }

    @When("click Register button")
    public void click_register_button() {
        registration.clickOnRegisterButton();
    }

    @Then("check text for successful registration")
    public void check_text_for_successful_registration() {
        Assert.assertEquals(true, registration.checkIfSuccessfulRegistration());
    }

}
