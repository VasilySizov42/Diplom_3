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
    private final WebDriver driver;
    public Home(WebDriver driver){
        this.driver = driver;
        driver.get(Constants.HOME);
    }
    private static final By ENTER_TO_ACCOUNT = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By PERSONAL_ACCOUNT = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    private static final By BUNS_BUTTON = By.xpath("//span[text()='Булки']/parent::div");
    private static final By SAUCES_BUTTON = By.xpath("//span[text()='Соусы']/parent::div");
    private static final By FILLINGS_BUTTON = By.xpath("//span[text()='Начинки']/parent::div");
    private static final By BUNS = By.xpath("//h2[text()='Булки']");
    private static final By SAUCES = By.xpath("//h2[text()='Соусы']");
    private static final By FILLINGS = By.xpath("//h2[text()='Начинки']");
    private static final By INGREDIENTS = By.xpath("//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer__')]");

    public static By getIngredients() {
        return INGREDIENTS;
    }
    @Step("click to Enter To Account button")
    public void clickEnterToAccountButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(ENTER_TO_ACCOUNT)));
        driver.findElement(ENTER_TO_ACCOUNT).click();
    }
    @Step("click to Personal Account button")
    public void clickPersonalAccountButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(PERSONAL_ACCOUNT)));
        driver.findElement(PERSONAL_ACCOUNT).click();
    }
    @Step("click to Buns button")
    public void clickBunsButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(BUNS_BUTTON)));
        driver.findElement(BUNS_BUTTON).click();
    }
    @Step("click to Sauces button")
    public void clickSaucesButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(SAUCES_BUTTON)));
        driver.findElement(SAUCES_BUTTON).click();
    }
    @Step("click to Fillings button")
    public void clickFillingsButton() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(FILLINGS_BUTTON)));
        driver.findElement(FILLINGS_BUTTON).click();
    }
    @Step("check switch to the fillings chapter in constructor block")
    public void checkSwitchToFillingsChapter() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(driver.findElement(FILLINGS_BUTTON), "class", "current"));
        System.out.println(driver.findElement(FILLINGS).getText());
        var actual = Methods.searchScrollBarPosition(driver);
        Assert.assertTrue(actual > 90);
    }
    @Step("check switch to the fillings chapter in constructor block")
    public void checkSwitchToSaucesChapter() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(driver.findElement(SAUCES_BUTTON), "class", "current"));
        System.out.println(driver.findElement(SAUCES).getText());
        var actual = Methods.searchScrollBarPosition(driver);
        Assert.assertTrue(actual <= 90 && actual > 15);
    }
    @Step("check switch to the buns chapter in constructor block")
    public void checkSwitchToBunsChapter() {
        Methods.waitForReady(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.attributeContains(driver.findElement(BUNS_BUTTON), "class", "current"));
        System.out.println(driver.findElement(BUNS).getText());
        var actual = Methods.searchScrollBarPosition(driver);
        Assert.assertTrue(actual <= 15);
    }
}
