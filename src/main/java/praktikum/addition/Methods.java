package praktikum.addition;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class Methods {
    public static void checkTransferToPage(WebDriver driver, String login, String home) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.
                        not(ExpectedConditions.urlToBe(login)));
        System.out.println("Текущая страница: " + driver.getCurrentUrl());
        var expected = home;
        var actual = driver.getCurrentUrl();
        Assert.assertEquals(expected, actual);
    }
    /*public static void waiterForCli(WebDriver driver, String login, String home) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.
                        not(ExpectedConditions.urlToBe(login)));
        System.out.println("Текущая страница: " + driver.getCurrentUrl());
        var expected = home;
        var actual = driver.getCurrentUrl();
        Assert.assertEquals(expected, actual);
    }*/
    public static UserForRegistration parserToUser(String fileName) throws IOException, ParseException {
        FileReader reader = new FileReader(fileName);
        JSONParser jsonParser = new JSONParser();        ;
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        return new UserForRegistration(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("email"),
                (String) jsonObject.get("password"));
    }

    public static String getToken(WebDriver driver) {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
        return accessToken;
    }
}
