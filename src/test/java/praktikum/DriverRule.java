package praktikum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.time.Duration;

import static praktikum.addition.Constants.*;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() throws Throwable {

        try {
            System.setProperty("browser", "chrome");
            switch (System.getProperty("browser")){
                case "firefox": setUpFirefox();
                    break;
                case "yandex": setUpChrome();
                    break;
                case "chrome": setUpChrome();
                    break;
                default: setUpFirefox();
            }
        }
        catch (NullPointerException e){
            // System.setProperty("browser", "firefox");
            System.out.println(System.getProperty("browser"));
            setUpFirefox();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPL_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PG_LOAD_TMT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCR_TMT));
        //driver.manage().window().maximize();
    }
    private void setUpFirefox(){
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
    }
    private void setUpChrome(){
        // драйвер для браузера Chrome
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/Program Files (x86)/Google/Chrome/chromedriver-win64/chromedriver.exe"))
                .build();

        ChromeOptions options = new ChromeOptions()
                //.setBinary("C:/Program Files (x86)/Google/Chrome/chrome-win64/chrome.exe");
                .setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
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
