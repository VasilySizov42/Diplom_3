package praktikum.pom;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.addition.Constants;
import praktikum.addition.Methods;

import java.time.Duration;

public class Home {
    private WebDriver driver;
    public Home(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.HOME);
    }
    private static final By enterToAccount = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By personalAccount = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    private static final By bunsButton = By.xpath("//span[text()='Булки']/parent::div");
    private static final By saucesButton = By.xpath("//span[text()='Соусы']/parent::div");
    private static final By fillingsButton = By.xpath("//span[text()='Начинки']/parent::div");
    private static final By buns = By.xpath("//h2[text()='Булки']");
    private static final By sauces = By.xpath("//h2[text()='Соусы']");
    private static final By fillings = By.xpath("//h2[text()='Начинки']");
    private static final By ingredients = By.xpath("//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer__')]");

    public static By getIngredients() {
        return ingredients;
    }
    @Step("click to Enter To Account button")
    public void clickEnterToAccountButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(enterToAccount)));
        driver.findElement(enterToAccount).click();
    }
    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(personalAccount)));
        driver.findElement(personalAccount).click();
    }
    @Step("click to Buns button")
    public void clickBunsButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(bunsButton)));
        driver.findElement(bunsButton).click();
    }
    @Step("click to Sauces button")
    public void clickSaucesButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(saucesButton)));
        driver.findElement(saucesButton).click();
    }
    @Step("click to Fillings button")
    public void clickFillingsButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(fillingsButton)));
        driver.findElement(fillingsButton).click();
    }
    @Step("check switch to the fillings chapter in constructor block")
    public void checkSwitchToFillingsChapter() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(driver.findElement(fillingsButton), "class", "current"));
        System.out.println(driver.findElement(fillings).getText());
        var actual = Methods.searchScrollBarPosition(driver);
        Assert.assertTrue(actual > 90);
    }
    @Step("check switch to the fillings chapter in constructor block")
    public void checkSwitchToSaucesChapter() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(driver.findElement(saucesButton), "class", "current"));
        System.out.println(driver.findElement(sauces).getText());
        var actual = Methods.searchScrollBarPosition(driver);
        Assert.assertTrue(actual <= 90 && actual > 15);
    }
    @Step("check switch to the buns chapter in constructor block")
    public void checkSwitchToBunsChapter() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(driver.findElement(bunsButton), "class", "current"));
        System.out.println(driver.findElement(buns).getText());
        var actual = Methods.searchScrollBarPosition(driver);
        Assert.assertTrue(actual <= 15);
    }
}
