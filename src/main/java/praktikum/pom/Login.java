package praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    public Login(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.LOGIN);
    }
    private static final By email = By.xpath("//div[contains(@class, 'input_type_text')]/input");
    private static final By password = By.xpath("//div[contains(@class, 'input_type_password')]/input");
    private static final By register = By.xpath("//a[text()='Зарегистрироваться']");
    private static final By recoverPassword = By.xpath("//a[text()='Восстановить пароль']");
    private static final By enter = By.xpath("//button[contains(@class, 'button_button')]");
    private static final By bubble = By.xpath("//div[contains(@class, 'Modal_modal_overlay__')]");
    private static final By personalAccount = By.xpath("//p[text()='Личный Кабинет']/parent::a");


    @Step("fill email field")
    public void fillEmailField(String value) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(value);
    }
    @Step("fill password field")
    public void fillPasswordField(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
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
        .until(ExpectedConditions.elementToBeClickable(driver.findElement(register)));
        driver.findElement(register).click();
    }
    @Step("click to Recover Password button")
    public void clickRecoverPasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(recoverPassword)));
        driver.findElement(recoverPassword).click();
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
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(personalAccount)));
        driver.findElement(personalAccount).click();
    }
}
