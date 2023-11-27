package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pom.Home;

public class ConstructorTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    WebDriver driver;

    @DisplayName("Check switch to feelings")
    @Description("Attempt switch to feelings in constructor")
    @Test
    public void switchToFeelings() {
        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickFillingsButton();
        objHome.checkSwitchToFillingsChapter();
    }
    @DisplayName("Check switch to sauces")
    @Description("Attempt switch to sauces in constructor")
    @Test
    public void switchToSauces() {
        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickSaucesButton();
        objHome.checkSwitchToSaucesChapter();
    }
    @DisplayName("Check switch to sauces")
    @Description("Attempt switch to sauces in constructor")
    @Test
    public void switchToBuns() {
        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickFillingsButton();
        objHome.clickBunsButton();
        objHome.checkSwitchToBunsChapter();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

