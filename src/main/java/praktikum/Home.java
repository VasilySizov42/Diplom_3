package praktikum;

import io.qameta.allure.Step;
import org.junit.Assert;
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
    private By enterToAccount = By.xpath("//button[text()='Войти в аккаунт']");
    private By personalAccount = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    private By bubble = By.xpath("//div[contains(@class, 'Modal_modal_overlay__')]");
    private By bunsButton = By.xpath("//span[text()='Булки']/parent::div");
    private By saucesButton = By.xpath("//span[text()='Соусы']/parent::div");
    private By fillingsButton = By.xpath("//span[text()='Начинки']/parent::div");
    private By buns = By.xpath("//h2[text()='Булки']");
    private By sauces = By.xpath("//h2[text()='Соусы']");
    private By fillings = By.xpath("//h2[text()='Начинки']");
    @Step("click to Enter To Account button")
    public void clickEnterToAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(enterToAccount)));
        driver.findElement(enterToAccount).click();
    }
    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        //.until(ExpectedConditions.invisibilityOf(driver.findElement(bubble)));
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(personalAccount)));
        driver.findElement(personalAccount).click();
    }
    @Step("click to Buns button")
    public void clickBunsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(bunsButton)));
        driver.findElement(bunsButton).click();
    }
    @Step("click to Sauces button")
    public void clickSaucesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(saucesButton)));
        driver.findElement(saucesButton).click();
    }
    @Step("click to Fillings button")
    public void clickFillingsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(fillingsButton)));
        driver.findElement(fillingsButton).click();
    }
}
