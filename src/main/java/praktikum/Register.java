package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class Register {
    private WebDriver driver;
    public Register(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.REGISTER);
    }
    private By enter = By.xpath("//a[contains(@class, 'Auth_link')]");
    private By register = By.xpath("//button[contains(@class, 'button_button')]");
    private By email = By.xpath("//div[contains(@class, 'input_type_text')]/input");
    private By password = By.xpath("//div[contains(@class, 'input_type_password')]/input");

    public void fillNameField(String value) {
        driver.findElements(email).get(0).clear();
        driver.findElements(email).get(0).sendKeys(value);
    }
    public void fillEmailField(String value) {
        driver.findElements(email).get(1).clear();
        driver.findElements(email).get(1).sendKeys(value);
    }
    public void fillPasswordField(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
    }
    public void registration(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
    }
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(register)));
        driver.findElement(register).click();
    }
    public void clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(enter)));
        driver.findElement(enter).click();
    }
}

