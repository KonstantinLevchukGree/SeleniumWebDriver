package utils.singleton;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyUtil;

import java.net.URL;
import java.util.Properties;

public class SingletonInstance {
    private static SingletonInstance instance;
    private WebDriver driver;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    private SingletonInstance() {
    }

    public static SingletonInstance getInstance() {
        if (instance == null) {
            instance = new SingletonInstance();
        }
        return instance;
    }

    @SneakyThrows
    public WebDriver getDriver() {
        if (dataTests.getProperty("environment").equals("local")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (dataTests.getProperty("environment").equals("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL(dataTests.getProperty("hub.url")), capabilities);
        }
        return driver;
    }

    public void quitAll() {
        driver.quit();
        driver = null;
    }
}
