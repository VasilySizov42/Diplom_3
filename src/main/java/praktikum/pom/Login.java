package praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class Login {
    private final WebDriver driver;
    public Login(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.LOGIN);
    }
    private static final By EMAIL = By.xpath("//div[contains(@class, 'input_type_text')]/input");
    private static final By PASSWORD = By.xpath("//div[contains(@class, 'input_type_password')]/input");
    private static final By REGISTER = By.xpath("//a[text()='Зарегистрироваться']");
    private static final By RECOVER_PASSWORD = By.xpath("//a[text()='Восстановить пароль']");
    private static final By ENTER = By.xpath("//button[contains(@class, 'button_button')]");
    private static final By PERSONAL_ACCOUNT = By.xpath("//p[text()='Личный Кабинет']/parent::a");


    @Step("fill email field")
    public void fillEmailField(String value) {
        driver.findElement(EMAIL).clear();
        driver.findElement(EMAIL).sendKeys(value);
    }
    @Step("fill password field")
    public void fillPasswordField(String value) {
        driver.findElement(PASSWORD).clear();
        driver.findElement(PASSWORD).sendKeys(value);
    }
    @Step("login")
    public void authorization(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
    }
    @Step("click to Register button")
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        //.until((ExpectedConditions.invisibilityOf(driver.findElement(bubble))));
        .until(ExpectedConditions.elementToBeClickable(driver.findElement(REGISTER)));
        driver.findElement(REGISTER).click();
    }
    @Step("click to Recover Password button")
    public void clickRecoverPasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(RECOVER_PASSWORD)));
        driver.findElement(RECOVER_PASSWORD).click();
    }
    @Step("click to Enter button")
    public void clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(ENTER)));
        driver.findElement(ENTER).click();
    }
    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(PERSONAL_ACCOUNT)));
        driver.findElement(PERSONAL_ACCOUNT).click();
    }
}
