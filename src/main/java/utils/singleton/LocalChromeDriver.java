package utils.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalChromeDriver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private LocalChromeDriver() {
    }

    public static WebDriver getInstance() {
        if (driver.get() == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            driver.set(new org.openqa.selenium.chrome.ChromeDriver(chromeOptions));
        }
        return driver.get();
    }

    public static void quit() {
        driver.get().quit();
        driver.remove();
    }
}
