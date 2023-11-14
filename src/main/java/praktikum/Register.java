package praktikum;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

import static praktikum.addition.Constants.INCORRECT_PASSWORD;

public class Register {
    private WebDriver driver;
    public Register(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.REGISTER);
    }
    private By enter = By.xpath("//a[contains(@class, 'Auth_link')]");
    private By register = By.xpath("//button[contains(@class, 'button_button')]");
    private By registrationFields = By.xpath("//form[contains(@class, 'Auth_form__')]//input");
    /*private By email = By.xpath("//div/input[contains(@value, null)]");
    private By password = By.xpath("//div/input[contains(@name, 'Пароль')]");
    private By name = By.xpath("//div/input[contains(@value, 'polk')]");*/
    private By alertIncorrectPassword = By.xpath("//p[contains(@class, 'input__error text_type_main-default')]");
    private By personalAccount = By.xpath("//p[text()='Личный Кабинет']/parent::a");

    @Step("fill name field")
    public void fillNameField(String value) {
        driver.findElements(registrationFields).get(0).clear();
        driver.findElements(registrationFields).get(0).sendKeys(value);
    }
    @Step("fill email field")
    public void fillEmailField(String value) {
        driver.findElements(registrationFields).get(1).clear();
        driver.findElements(registrationFields).get(1).sendKeys(value);
    }
    @Step("fill password field")
    public void fillPasswordField(String value) {
        driver.findElements(registrationFields).get(2).clear();
        driver.findElements(registrationFields).get(2).sendKeys(value);
    }
    public void registration(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
    }
    @Step("click to Register button")
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(register)));
        driver.findElement(register).click();
    }
    @Step("click to Enter button")
    public void clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(enter)));
        driver.findElement(enter).click();
    }
    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                //.until(ExpectedConditions.invisibilityOf(driver.findElement(bubble)));
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(personalAccount)));
        driver.findElement(personalAccount).click();
    }
    @Step("check the appearance of the \"incorrect password\" warning")
    public void checkAlertIncorrectPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.
                        visibilityOf(driver.findElement(alertIncorrectPassword)));
        var actual = driver.findElement(alertIncorrectPassword).getText();
        Assert.assertEquals(INCORRECT_PASSWORD, actual);
    }
}

