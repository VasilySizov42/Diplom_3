package praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class ForgotPassword {
    private final WebDriver driver;
    public ForgotPassword(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.FORGOT_PASSWORD);
    }
    private static final By ENTER = By.xpath("//a[contains(@class, 'Auth_link')]");
    private static final By PERSONAL_ACCOUNT = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(PERSONAL_ACCOUNT)));
        driver.findElement(PERSONAL_ACCOUNT).click();
    }
    @Step("click to Enter button")
    public void clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(ENTER)));
        driver.findElement(ENTER).click();
    }
}

