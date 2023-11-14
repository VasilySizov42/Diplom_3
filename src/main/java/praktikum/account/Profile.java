package praktikum.account;

import io.qameta.allure.Step;
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
        if (driver.getCurrentUrl().equals(Constants.PROFILE))
        driver.getCurrentUrl();
        else driver.get(Constants.PROFILE);
    }
    private By exit = By.xpath("//button[contains(@class, 'Account_button')]");
    private By personalAccount = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    private By constructor = By.xpath("//p[contains(@class, 'AppHeader_header__linkText__')]/parent::a");
    private By stellarBurger = By.xpath("//div[contains(@class, 'AppHeader_header__logo__')]/a");
    @Step("click to Exit button")
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(exit)));
        driver.findElement(exit).click();
    }
    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(personalAccount)));
        driver.findElement(personalAccount).click();
    }
    @Step("click to Constructor button")
    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(constructor)));
        driver.findElement(constructor).click();
    }
    @Step("click to Stellar Burger button")
    public void clickStellarBurgerButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(stellarBurger)));
        driver.findElement(stellarBurger).click();
    }
}
