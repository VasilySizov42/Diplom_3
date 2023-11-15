package praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class Feed {
    private WebDriver driver;
    public Feed(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.FEED);
    }
    private static final By personalAccount = By.xpath("//p[text()='Личный Кабинет']/parent::a");

    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                //.until(ExpectedConditions.invisibilityOf(driver.findElement(bubble)));
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(personalAccount)));
        driver.findElement(personalAccount).click();
    }
}
