package praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class Profile {
    private final WebDriver driver;
    public Profile(WebDriver driver){
        this.driver = driver;
        if (driver.getCurrentUrl().equals(Constants.PROFILE))
        driver.getCurrentUrl();
        else driver.get(Constants.PROFILE);
    }
    private static final By EXIT = By.xpath("//button[contains(@class, 'Account_button')]");
    private static final By PERSONAL_ACCOUNT = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    private static final By CONSTRUCTOR = By.xpath("//p[contains(@class, 'AppHeader_header__linkText__')]/parent::a");
    private static final By STELLAR_BURGER = By.xpath("//div[contains(@class, 'AppHeader_header__logo__')]/a");
    @Step("click to Exit button")
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(EXIT)));
        driver.findElement(EXIT).click();
    }
    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(PERSONAL_ACCOUNT)));
        driver.findElement(PERSONAL_ACCOUNT).click();
    }
    @Step("click to Constructor button")
    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(CONSTRUCTOR)));
        driver.findElement(CONSTRUCTOR).click();
    }
    @Step("click to Stellar Burger button")
    public void clickStellarBurgerButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(STELLAR_BURGER)));
        driver.findElement(STELLAR_BURGER).click();
    }
}
