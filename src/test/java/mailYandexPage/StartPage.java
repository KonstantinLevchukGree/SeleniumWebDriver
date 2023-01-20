package mailYandexPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyUtil;

import java.util.Properties;

public class StartPage {
    private final WebDriver driver;
    private final By LOGIN_BUTTON = By.xpath("//button[contains(@class,'Login')]");
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public StartPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("mailYandexUrl"));
    }

    public LoginPage openLoginPage() {
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }
}
