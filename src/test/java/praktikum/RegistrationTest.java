package praktikum;

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.addition.Methods;
import praktikum.addition.UserForRegistration;

import java.io.IOException;

import static praktikum.addition.Constants.*;
import static praktikum.addition.Methods.checkTransferToPage;
import static praktikum.addition.Methods.deleteUser;

public class RegistrationTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    WebDriver driver;
    UserForRegistration userForRegistration;

    @Test
    public void successfullyRegistrationTest() throws IOException, ParseException {

        userForRegistration = Methods.parserToUser(SUCCESS_LOGIN);
        System.out.println(userForRegistration.getName());
        System.out.println(userForRegistration.getEmail());
        System.out.println(userForRegistration.getPassword());
        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, LOGIN);

        Login objLogin = new Login(driver);
        objLogin.clickRegisterButton();
        checkTransferToPage(driver, LOGIN, REGISTER);

        Register objRegister = new Register(driver);
        objRegister.registration(userForRegistration.getName(), userForRegistration.getEmail(),
                userForRegistration.getPassword());
        objRegister.clickRegisterButton();
        checkTransferToPage(driver, REGISTER, LOGIN);

    }
    @Test
    public void registrationWithWrongPasswordTest() throws IOException, ParseException {

        userForRegistration = Methods.parserToUser(LOGIN_WITH_WRONG_PASSWORD);
        System.out.println(userForRegistration.getName());
        System.out.println(userForRegistration.getEmail());
        System.out.println(userForRegistration.getPassword());
        driver = driverRule.getDriver();
        Home objHome = new Home(driver);
        objHome.clickPersonalAccountButton();
        checkTransferToPage(driver, HOME, LOGIN);

        Login objLogin = new Login(driver);
        objLogin.clickRegisterButton();
        checkTransferToPage(driver, LOGIN, REGISTER);

        Register objRegister = new Register(driver);
        objRegister.registration(userForRegistration.getName(), userForRegistration.getEmail(),
                userForRegistration.getPassword());
        objRegister.clickRegisterButton();
        objRegister.checkAlertWrongPassword();
    }
    @After
    public void tearDown(){
        try {
            var cred = Methods.genericUserCredentials(userForRegistration);
            var login = Methods.loginUser(cred);
            var token = Methods.getUserAccessToken(login);
            deleteUser(token);
            driver.quit();
        }
        catch (Exception e){
            System.out.println(AUTHORIZATION_NOT_POSSIBLE);
        }
    }
}