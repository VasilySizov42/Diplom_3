package praktikum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

import static praktikum.addition.Constants.*;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() {

        try {
            //System.setProperty("browser", "yandex");
            switch (System.getProperty("browser")){
                case "yandex": setUpYandex();
                    break;
                case "chrome": setUpChrome();
                    break;
                default: setUpChrome();
            }
        }
        catch (NullPointerException e){
            System.out.println(System.getProperty("browser"));
            setUpChrome();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPL_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PG_LOAD_TMT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCR_TMT));
        //driver.manage().window().maximize();
    }

    private void setUpChrome(){
        // драйвер для браузера Chrome
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"
        );
        driver = new ChromeDriver();
    }
    private void setUpYandex(){
        // драйвер для браузера Chrome
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/Program Files (x86)/Google/Chrome/yandexdriver-win64/yandexdriver.exe"
        );
        driver = new ChromeDriver();
    }
    @Override
    protected void after() {
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
