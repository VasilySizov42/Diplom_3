package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.addition.Methods;
import praktikum.addition.RequestsToAPI;
import praktikum.addition.User;
import praktikum.pom.Home;
import praktikum.pom.Login;
import praktikum.pom.Register;

import java.io.IOException;

import static praktikum.addition.Constants.*;
import static praktikum.addition.Methods.checkTransferToPage;
import static praktikum.addition.RequestsToAPI.deleteUser;

public class RegistrationTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    WebDriver driver;
    User user;

    @DisplayName("Check successfully user registration")
    @Description("Attempt to register a user with acceptable parameters")
    @Test
    public void successfullyRegistrationTest() throws IOException, ParseException {

        user = Methods.parserToUser(SUCCESS_LOGIN);
        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, LOGIN);

        Login objLogin = new Login(driver);
        objLogin.clickRegisterButton();
        checkTransferToPage(driver, LOGIN, REGISTER);

        Register objRegister = new Register(driver);
        objRegister.registration(user.getName(), user.getEmail(),
                user.getPassword());
        objRegister.clickRegisterButton();
        checkTransferToPage(driver, REGISTER, LOGIN);

    }
    @DisplayName("Check registration with wrong password")
    @Description("Attempt to register a user with a length less than acceptable")
    @Test
    public void registrationWithWrongPasswordTest() throws IOException, ParseException {

        user = Methods.parserToUser(LOGIN_WITH_WRONG_PASSWORD);
        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, LOGIN);

        Login objLogin = new Login(driver);
        objLogin.clickRegisterButton();
        checkTransferToPage(driver, LOGIN, REGISTER);

        Register objRegister = new Register(driver);
        objRegister.registration(user.getName(), user.getEmail(),
                user.getPassword());
        objRegister.clickRegisterButton();
        objRegister.checkAlertIncorrectPassword();
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