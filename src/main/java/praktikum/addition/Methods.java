package praktikum.addition;

import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.pom.Home;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class Methods {
    @Step("check transfer to expected page")
    public static void checkTransferToPage(WebDriver driver, String previousPage, String currentPage) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.
                        not(ExpectedConditions.urlToBe(previousPage)));
        System.out.println("Текущая страница: " + driver.getCurrentUrl());
        var actual = driver.getCurrentUrl();
        Assert.assertEquals(currentPage, actual);
    }
    @Step("parse JSON to user")
    public static User parserToUser(String fileName) throws IOException, ParseException {
        FileReader reader = new FileReader(fileName);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        return new User(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("email"),
                (String) jsonObject.get("password"));
    }
    @Step("user credentials generation")
    public static Credentials genericUserCredentials(User user) {
        return new Credentials(user.getEmail(), user.getPassword());
    }

    public static int searchScrollBarPosition(WebDriver driver) {
        var clientHeight = driver.findElement(Home.getIngredients()).getDomProperty("clientHeight");
        var scrollTop = driver.findElement(Home.getIngredients()).getDomProperty("scrollTop");
        //System.out.println((Integer.parseInt (scrollTop)*100)/Integer.parseInt (clientHeight));
        return (Integer.parseInt (scrollTop)*100)/Integer.parseInt (clientHeight);
    }

    public static void waitForReady(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(waitForElementAnimationToFinish("//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer__')]"));
    }

    public static ExpectedCondition<Boolean> waitForElementAnimationToFinish(final String xPass) {
        return new ExpectedCondition<>() {
            private double x = 0;
            private double y = 0;
            private double width = 0;
            private double height = 0;

            private double convertToDouble(Object longValue) {
                if (longValue instanceof Long) {
                    return ((Long) longValue).doubleValue();
                }

                return (double) longValue;
            }

            @Override
            public Boolean apply(WebDriver driver) {
                WebElement elem = driver.findElement(By.xpath(String.valueOf(xPass)));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                Map<String, Object> rect = (Map<String, Object>) executor.executeScript("var rect = arguments[0].getBoundingClientRect(); return { x: rect.x, y: rect.y, width: rect.width, height: rect.height };", elem);

                double newX = convertToDouble(rect.get("x"));
                double newY = convertToDouble(rect.get("y"));
                double newWidth = convertToDouble(rect.get("width"));
                double newHeight = convertToDouble(rect.get("height"));

                if (newX != x || newY != y || newWidth != width || newHeight != height) {
                    x = newX;
                    y = newY;
                    width = newWidth;
                    height = newHeight;
                    return false;
                }

                return true;
            }

            @Override
            public String toString() {
                return String.format("XPass: \"%s\"", xPass);
            }
        };
    }
}
