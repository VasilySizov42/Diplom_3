package praktikum;

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.addition.Methods;
import praktikum.addition.RequestsToAPI;
import praktikum.addition.User;

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
    public void register() throws IOException, ParseException {
        user = Methods.parserToUser(SUCCESS_LOGIN);
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        RequestsToAPI.registerUser(user);
    }
    @Test
    public void transferToPersonalAccountFromHomePage() {

        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, LOGIN);
    }
    @Test
    public void transferToPersonalAccountFromForgotPasswordPage() {

        driver = driverRule.getDriver();
        ForgotPassword objForgotPassword = new ForgotPassword(driver);
        objForgotPassword.clickPersonalAccountButton();
        checkTransferToPage(driver, FORGOT_PASSWORD, LOGIN);
    }
    @Test
    public void transferToPersonalAccountFromRegisterPage() {

        driver = driverRule.getDriver();
        Register objRegister = new Register(driver);
        objRegister.clickPersonalAccountButton();
        checkTransferToPage(driver, REGISTER, LOGIN);
    }
    @Test
    public void transferToPersonalAccountFromFeedPage() {

        driver = driverRule.getDriver();
        Feed objFeed = new Feed(driver);
        objFeed.clickPersonalAccountButton();
        checkTransferToPage(driver, FEED, LOGIN);
    }
    @Test
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
