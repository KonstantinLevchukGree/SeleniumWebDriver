package utils.singleton;

import lombok.SneakyThrows;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyUtil;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public class SingletonInstance {
    private static SingletonInstance instance;
    private WebDriver driver;
    private final Properties testsData = PropertyUtil.getProperties("testsData.properties");
    private final Properties sauceLab = PropertyUtil.getProperties("sauceLab.properties");
    private final Properties chromeEnvironment = PropertyUtil.getProperties("chromeEnvironment.properties");
    private final Properties edgeEnvironment = PropertyUtil.getProperties("edgeEnvironment.properties");
    private final Properties firefoxEnvironment = PropertyUtil.getProperties("firefoxEnvironment.properties");

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
        if (testsData.getProperty("environment").equals("local")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else if (testsData.getProperty("environment").equals("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL(testsData.getProperty("hub.url")), capabilities);
        } else if (testsData.getProperty("environment").equals("remoteSauceLabs")) {
            authenticationSauceLab();
            driver = getRemoteWebDriverBrowser(sauceLab.getProperty("browser"));
        }
        return driver;
    }

    @SneakyThrows
    private WebDriver getRemoteWebDriverBrowser(String browser) {
        switch (browser) {
            case "chrome":
                driver = new RemoteWebDriver(new URL(sauceLab.getProperty("user.url")), setChromeOptions());
                break;
            case "firefox":
                driver = new RemoteWebDriver(new URL(sauceLab.getProperty("user.url")), setFirefoxOptions());
                break;
            case "edge":
                driver = new RemoteWebDriver(new URL(sauceLab.getProperty("user.url")), setEdgeOptions());
                break;
        }
        return driver;
    }

    private DesiredCapabilities setChromeOptions() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", chromeEnvironment.getProperty("browser"));
        caps.setCapability("platform", chromeEnvironment.getProperty("platform"));
        caps.setCapability("version", chromeEnvironment.getProperty("version"));
        caps.setCapability("build", chromeEnvironment.getProperty("build"));
        caps.setCapability("name", getTestAndClassName());
        return caps;
    }

    private DesiredCapabilities setFirefoxOptions() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", firefoxEnvironment.getProperty("browser"));
        caps.setCapability("platform", firefoxEnvironment.getProperty("platform"));
        caps.setCapability("version", firefoxEnvironment.getProperty("version"));
        caps.setCapability("build", firefoxEnvironment.getProperty("build"));
        caps.setCapability("name", getTestAndClassName());
        return caps;
    }

    private EdgeOptions setEdgeOptions() {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName", edgeEnvironment.getProperty("platform"));
        browserOptions.setCapability("browserVersion", edgeEnvironment.getProperty("version"));
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", edgeEnvironment.getProperty("build"));
        sauceOptions.put("name", getTestAndClassName());
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }

    private String getTestAndClassName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String testName = null;
        for (StackTraceElement element : stackTrace
        ) {
            if (element.getFileName().replace(".java", "").trim().endsWith("Test")) {
                testName = "Test: " + element.getMethodName()
                        + "__Class: " + element.getFileName().replace(".java", "").trim()
                        + "__Package: " + element.getClassName().split(Pattern.quote("."))[0];
            }
        }
        return testName;
    }

    private void authenticationSauceLab() {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv(sauceLab.getProperty("user.name")));
        sauceOptions.setCapability("access_key", System.getenv(sauceLab.getProperty("access.key")));
    }

    public void quitAll() {
        driver.quit();
        driver = null;
    }
}
