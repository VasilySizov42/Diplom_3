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
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/Program Files (x86)/Google/Chrome/chromedriver-win64/chromedriver.exe"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
        driver = new ChromeDriver(service, options);
    }
    private void setUpYandex(){
        // драйвер для браузера Chrome
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/Program Files (x86)/Google/Chrome/yandexdriver-win64/yandexdriver.exe"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("C:/Users/Vasiliy/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        driver = new ChromeDriver(service, options);
    }
    @Override
    protected void after() {
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
