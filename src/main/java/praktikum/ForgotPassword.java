package praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class ForgotPassword {
    private WebDriver driver;
    public ForgotPassword(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.FORGOT_PASSWORD);
    }
    private By enter = By.xpath("//a[contains(@class, 'Auth_link')]");
    @Step("click to Enter button")
    public void clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(enter)));
        driver.findElement(enter).click();
    }
}

