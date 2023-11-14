package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.account.Profile;
import praktikum.addition.Methods;
import praktikum.addition.RequestsToAPI;
import praktikum.addition.User;

import java.io.IOException;

import static praktikum.addition.Constants.*;
import static praktikum.addition.Methods.checkTransferToPage;
import static praktikum.addition.RequestsToAPI.deleteUser;

public class QuitFromAccountTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    WebDriver driver;
    User user;
    @Before
    @DisplayName("Create new user")
    @Description("Attempt to create a new user with static profile data")
    public void register() throws IOException, ParseException {
        user = Methods.parserToUser(SUCCESS_LOGIN);
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        RequestsToAPI.registerUser(user);
    }
    @Test
    @DisplayName("Check quit from account")
    @Description("Attempt to quit from account via Quit button in Profile page")
    public void quitFromAccount() {
        driver = driverRule.getDriver();
        Login objLogin = new Login(driver);
        objLogin.authorization(user.getEmail(), user.getPassword());
        objLogin.clickEnterButton();
        checkTransferToPage(driver, LOGIN, HOME);
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, PROFILE);
        Profile objProfile = new Profile(driver);
        objProfile.clickExitButton();
        checkTransferToPage(driver, PROFILE, LOGIN);
    }
    @After
    @DisplayName("Delete created user")
    @Description("Attempt to delete created user")
    public void tearDown(){
        try {
            var cred = Methods.genericUserCredentials(user);
            var login = RequestsToAPI.loginUser(cred);
            var token = RequestsToAPI.getUserAccessToken(login);
            deleteUser(token);
        }
        catch (Exception e){
            System.out.println(AUTHORIZATION_NOT_POSSIBLE);
            driver.quit();
        }
    }
}
