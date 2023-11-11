package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;

import java.time.Duration;

public class Home {
    private WebDriver driver;
    public Home(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.HOME);
    }
    //Кнопка "Войти в аккаунт"
    private By enterToAccount = By.xpath("//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    private By personalAccount = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    //[contains(@class, 'AppHeader_header__link')]
    public void clickEnterTolAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(enterToAccount)));
        driver.findElement(enterToAccount).click();
    }
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(personalAccount)));
        driver.findElement(personalAccount).click();
    }
}
