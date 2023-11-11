package praktikum.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class Profile {
    private WebDriver driver;
    public Profile(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.PROFILE);
    }
    private By exit = By.xpath("//button[contains(@class, 'Account_button')]");
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(exit)));
        driver.findElement(exit).click();
    }
}
