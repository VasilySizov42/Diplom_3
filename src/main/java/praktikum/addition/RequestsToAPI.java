package praktikum.addition;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import static io.restassured.RestAssured.given;
import static praktikum.addition.Constants.*;

public class RequestsToAPI {
    @Step("register a new user")
    public static void registerUser(User user) {
        given().log().method()
                .contentType(ContentType.JSON)
                .baseUri(HOME)
                .body(user)
                .when()
                .post(USER_REGISTER_HANDLE)
                .then().log().body();
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
    @Step("get user access token via login request")
    public static String getUserAccessToken(ValidatableResponse response) {
        return response
                .extract()
                .path("accessToken")
                .toString()
                ;
    }
    @Step("get user access token via Local Storage")
    public static String getToken(WebDriver driver) {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
        return accessToken;
    }
}
