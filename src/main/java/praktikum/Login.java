package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

import static org.hamcrest.Matchers.not;

public class Login {
    private WebDriver driver;
    public Login(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.LOGIN);
    }
    private By email = By.xpath("//div[contains(@class, 'input_type_text')]/input");
    private By password = By.xpath("//div[contains(@class, 'input_type_password')]/input");
    private By register = By.xpath("//a[text()='Зарегистрироваться']");
    private By recoverPassword = By.xpath("//a[text()='Восстановить пароль']");
    private By enter = By.xpath("//button[contains(@class, 'button_button')]");
    private By buble = By.xpath("//div[contains(@class, 'Modal_modal_overlay__')]");

    public void fillEmailField(String value) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(value);
    }
    public void fillPasswordField(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
    }
    public void authorization(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
    }
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until((ExpectedConditions.invisibilityOf(driver.findElement(buble))));
        //.until(ExpectedConditions.elementToBeClickable(driver.findElement(register)));
        //div class="Modal_modal_overlay__x2ZCr"
        driver.findElement(register).click();
    }
    public void clickRecoverPasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(recoverPassword)));
        driver.findElement(recoverPassword).click();
    }
    public void clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(enter)));
        driver.findElement(enter).click();
    }

}
