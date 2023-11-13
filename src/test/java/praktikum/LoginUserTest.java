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

public class LoginUserTest {
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
