package praktikum.addition;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.Credentials;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import static io.restassured.RestAssured.given;
import static praktikum.addition.Constants.*;

public class Methods {
    public static void checkTransferToPage(WebDriver driver, String previousPage, String currentPage) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.
                        not(ExpectedConditions.urlToBe(previousPage)));
        System.out.println("Текущая страница: " + driver.getCurrentUrl());
        var expected = currentPage;
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
    @Step("login a user")
    public static ValidatableResponse loginUser(Credentials cred) {
        return given().log().method()
                .contentType(ContentType.JSON)
                .baseUri(HOME)
                .body(cred)
                .when()
                .post(USER_LOGIN_HANDLE)
                .then().log().body()
                ;
    }
    @Step("delete a user")
    public static ValidatableResponse deleteUser(String token) {
        return given().log().method()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .baseUri(HOME)
                .when()
                .delete(USER_CHANGE_DELETE_HANDLE)
                .then().log().body()
                ;
    }
    @Step("get user access token")
    public static String getUserAccessToken(ValidatableResponse response) {
        return response
                .extract()
                .path("accessToken")
                .toString()
                ;
    }
    @Step("user credentials generation")
    public static Credentials genericUserCredentials(UserForRegistration user) {
        return new Credentials(user.getEmail(), user.getPassword());
    }

}
