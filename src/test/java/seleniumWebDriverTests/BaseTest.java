package seleniumWebDriverTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.StartPage;

public class BaseTest {
    private static WebDriver driver;

    //properties
    private static String homeLink = "https://mail.yandex.com/";
    public static StartPage startPage;

    @BeforeClass
    public static void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //chromeOptions.setHeadless(true);

        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get(homeLink);
        startPage = new StartPage(driver);
    }

    @AfterClass
    public static void closeChrome() {
        driver.quit();
    }
}
