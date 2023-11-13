package praktikum.addition;

import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

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
}
