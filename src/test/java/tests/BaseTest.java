package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.StartPage;
import utils.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    public StartPage startPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @Before
    public void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //chromeOptions.setHeadless(true);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(dataTests.getProperty("uri"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        startPage = new StartPage(driver, wait);
    }

    @After
    public void closeChrome() {
        driver.quit();
    }
}
