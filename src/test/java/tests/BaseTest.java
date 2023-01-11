package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.StartPage;
import utils.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    private static WebDriver driver;
    public static StartPage startPage;
    public static WebDriverWait wait;
    private static final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @BeforeClass
    public static void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
       // chromeOptions.setHeadless(true);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(dataTests.getProperty("uri"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        startPage = new StartPage(driver);
    }

    @AfterClass
    public static void closeChrome() {
        driver.quit();
    }
}
