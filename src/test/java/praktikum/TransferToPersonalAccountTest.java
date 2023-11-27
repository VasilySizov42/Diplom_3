package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.addition.Methods;
import praktikum.addition.RequestsToAPI;
import praktikum.addition.User;
import praktikum.pom.*;

import java.io.IOException;

import static praktikum.addition.Constants.*;
import static praktikum.addition.Methods.checkTransferToPage;
import static praktikum.addition.RequestsToAPI.deleteUser;

public class TransferToPersonalAccountTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    WebDriver driver;
    User user;
    @Before
    @DisplayName("Create new user")
    @Description("Attempt to create a new user with static profile data")
    public void register() throws IOException, ParseException {
        user = Methods.parserToUser(SUCCESS_LOGIN);
        RequestsToAPI.registerUser(user);
    }
    @Test
    @DisplayName("Check transfer to Personal Account from Home page")
    @Description("Attempt to transfer to Personal Account from Home page")
    public void transferToPersonalAccountFromHomePage() {
        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, LOGIN);
    }
    @Test
    @DisplayName("Check transfer to Personal Account from Forgot Password page")
    @Description("Attempt to transfer to Personal Account from Forgot Password page")
    public void transferToPersonalAccountFromForgotPasswordPage() {
        driver = driverRule.getDriver();
        ForgotPassword objForgotPassword = new ForgotPassword(driver);
        objForgotPassword.clickPersonalAccountButton();
        checkTransferToPage(driver, FORGOT_PASSWORD, LOGIN);
    }
    @Test
    @DisplayName("Check transfer to Personal Account from Register page")
    @Description("Attempt to transfer to Personal Account from Register page")
    public void transferToPersonalAccountFromRegisterPage() {
        driver = driverRule.getDriver();
        Register objRegister = new Register(driver);
        objRegister.clickPersonalAccountButton();
        checkTransferToPage(driver, REGISTER, LOGIN);
    }
    @Test
    @DisplayName("Check transfer to Personal Account from Feed page")
    @Description("Attempt to transfer to Personal Account from Feed page")
    public void transferToPersonalAccountFromFeedPage() {
        driver = driverRule.getDriver();
        Feed objFeed = new Feed(driver);
        objFeed.clickPersonalAccountButton();
        checkTransferToPage(driver, FEED, LOGIN);
    }
    @Test
    @DisplayName("Check transfer to Personal Account with authorization from Home page")
    @Description("Attempt to transfer to Personal Account with authorization from Home page")
    public void transferToPersonalAccountWithAuthorization() {

        driver = driverRule.getDriver();
        Login objLogin = new Login(driver);
        objLogin.authorization(user.getEmail(), user.getPassword());
        objLogin.clickEnterButton();
        checkTransferToPage(driver, LOGIN, HOME);
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, PROFILE);
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
