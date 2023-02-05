package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Registration {
    //HomePage
    String logoPageRegistration = "//img[@alt='nopCommerce demo store']";
    String registrationHrefOnHeader = "//a[normalize-space()='Register']";

    //RegistrationPage
    String registerTextOnRegisterPage = "//h1[normalize-space()='Register']";
    String radioButtonForGenderMale = "//input[@id='gender-male']";
    String radioButtonForGenderFemale = "//input[@id='gender-Female']";
    String firstNameTextField = "//input[@id='FirstName']";
    String lastNameTextField = "//input[@id='LastName']";
    String daysOfBirth = "//div[@class='inputs date-of-birth']//div//select[1]//option";
    String monthsOfBirth = "//div[@class='inputs date-of-birth']//div//select[2]//option";
    String yearsOfBirth = "//div[@class='inputs date-of-birth']//div//select[3]//option";
    String email = "//input[@id='Email']";
    String companyName = "//input[@id='Company']";
    String newsletter = "//input[@id='Newsletter']";
    String password = "//input[@id='Password']";
    String confirmPassword = "//input[@id='ConfirmPassword']";
    String registerButton = "//button[@id='register-button']";

    //After successful registration
    String resultOfSuccessfulRegistration = "//div[@class='result']";

    public WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By logoPageRegistrationLocator = new By.ByXPath(logoPageRegistration);
    By registrationHrefOnHeaderLocator = new By.ByXPath(registrationHrefOnHeader);
    By registerTextOnRegisterPageLocator = new By.ByXPath(registerTextOnRegisterPage);
    By radioButtonForGenderMaleLocator = new By.ByXPath(radioButtonForGenderMale);
    By radioButtonForGenderFemaleLocator = new By.ByXPath(radioButtonForGenderFemale);
    By firstNameTextFieldLocator = new By.ByXPath(firstNameTextField);
    By lastNameTextFieldLocator = new By.ByXPath(lastNameTextField);
    By daysOfBirthLocator = new By.ByXPath(daysOfBirth);
    By monthsOfBirthLocator = new By.ByXPath(monthsOfBirth);
    By yearsOfBirthLocator = new By.ByXPath(yearsOfBirth);
    By emailLocator = new By.ByXPath(email);
    By companyNameLocator = new By.ByXPath(companyName);
    By newsletterLocator = new By.ByXPath(newsletter);
    By passwordLocator = new By.ByXPath(password);
    By confirmPasswordLocator = new By.ByXPath(confirmPassword);
    By registerButtonLocator = new By.ByXPath(registerButton);
    By resultOfSuccessfulRegistrationLocator = new By.ByXPath(resultOfSuccessfulRegistration);

    //Actions
    public boolean checkLogoPresentOnRegistrationPage() {
        boolean status = driver.findElement(logoPageRegistrationLocator).isDisplayed();
        return status;
    }

    public void clickOnRegisterHrefOnHeader() {
        driver.findElement(registrationHrefOnHeaderLocator).click();
    }

    public boolean checkRegisterPage() {
        boolean status = driver.findElement(registerTextOnRegisterPageLocator).isDisplayed();
        return status;
    }

    public void setGender(String gender) {
        if (gender.toLowerCase().equals("male")) {
            driver.findElement(radioButtonForGenderMaleLocator).click();
        } else if (gender.toLowerCase().equals("female")) {
            driver.findElement(radioButtonForGenderFemaleLocator).click();
        }
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameTextFieldLocator).clear();
        driver.findElement(firstNameTextFieldLocator).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameTextFieldLocator).clear();
        driver.findElement(lastNameTextFieldLocator).sendKeys(lastName);
    }

    public void setDayOfBirth(String day) {
        List<WebElement> days = driver.findElements(daysOfBirthLocator);

        for (WebElement element : days) {
            if (element.getText().equals(day)) {
                element.click();
                break;
            }
        }
    }

    public void setMonthOfBirth(String month) {
        List<WebElement> months = driver.findElements(monthsOfBirthLocator);

        for (WebElement element : months) {
            if (element.getText().toLowerCase().equals(month.toLowerCase())) {
                element.click();
                break;
            }
        }
    }

    public void setYearOfBirth(String year) {
        List<WebElement> years = driver.findElements(yearsOfBirthLocator);

        for (WebElement element : years) {
            if (element.getText().equals(year)) {
                element.click();
                break;
            }
        }
    }

    public void setEmail(String email) {
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void setCompanyName(String companyName) {
        driver.findElement(companyNameLocator).clear();
        driver.findElement(companyNameLocator).sendKeys(companyName);
    }

    public void setNewsletterBox(String newsletter) {

        if (newsletter.toLowerCase().equals("yes")) {
            if (!driver.findElement(newsletterLocator).isSelected()) {
                driver.findElement(newsletterLocator).click();
            }
        } else if (newsletter.toLowerCase().equals("no")) {
            if (driver.findElement(newsletterLocator).isSelected()) {
                driver.findElement(newsletterLocator).click();
            }
        }
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        driver.findElement(confirmPasswordLocator).clear();
        driver.findElement(confirmPasswordLocator).sendKeys(password);
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButtonLocator).click();
    }

    public boolean checkIfSuccessfulRegistration() {
        boolean status = driver.findElement(resultOfSuccessfulRegistrationLocator).isDisplayed();
        return status;
    }
}
