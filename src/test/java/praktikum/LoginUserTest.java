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
import praktikum.pom.ForgotPassword;
import praktikum.pom.Home;
import praktikum.pom.Login;
import praktikum.pom.Register;

import java.io.IOException;

import static praktikum.addition.Constants.*;
import static praktikum.addition.Methods.checkTransferToPage;
import static praktikum.addition.RequestsToAPI.deleteUser;

public class LoginUserTest {
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
    @DisplayName("Check login via Personal Account button")
    @Description("Attempt to login a user via Personal Account button in Home page")
    public void loginViaPersonalAccountButton() {

        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, LOGIN);

        Login objLogin = new Login(driver);
        objLogin.authorization(user.getEmail(), user.getPassword());
        objLogin.clickEnterButton();
        checkTransferToPage(driver, LOGIN, HOME);
    }
    @Test
    @DisplayName("Check login via Enter To Account button")
    @Description("Attempt to login a user via Enter To Account button in Home page")
    public void loginViaEnterToAccountButton() {

        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickEnterToAccountButton();
        checkTransferToPage(driver, HOME, LOGIN);

        Login objLogin = new Login(driver);
        objLogin.authorization(user.getEmail(), user.getPassword());
        objLogin.clickEnterButton();
        checkTransferToPage(driver, LOGIN, HOME);
    }
    @Test
    @DisplayName("Check login via Enter button in Registration page")
    @Description("Attempt to login a user via Enter button in Registration page")
    public void loginViaEnterInRegistrationPage() {

        driver = driverRule.getDriver();
        Register objRegister = new Register(driver);
        objRegister.clickEnterButton();
        checkTransferToPage(driver, REGISTER, LOGIN);

        Login objLogin = new Login(driver);
        objLogin.authorization(user.getEmail(), user.getPassword());
        objLogin.clickEnterButton();
        checkTransferToPage(driver, LOGIN, HOME);
    }
    @Test
    @DisplayName("Check login via Enter button in Forgot Password page")
    @Description("Attempt to login a user via Enter button in Forgot Password page")
    public void loginViaEnterInForgotPasswordPage() {

        driver = driverRule.getDriver();
        ForgotPassword objRegister = new ForgotPassword(driver);
        objRegister.clickEnterButton();
        checkTransferToPage(driver, FORGOT_PASSWORD, LOGIN);

        Login objLogin = new Login(driver);
        objLogin.authorization(user.getEmail(), user.getPassword());
        objLogin.clickEnterButton();
        checkTransferToPage(driver, LOGIN, HOME);
    }
    @After
    @DisplayName("Delete created user")
    @Description("Attempt to delete created user")
    public void tearDown(){
        try {
            var token = RequestsToAPI.getToken(driver);
            deleteUser(token);
        }
        catch (Exception e){
            System.out.println(AUTHORIZATION_NOT_POSSIBLE);
            driver.quit();
        }
    }
}
