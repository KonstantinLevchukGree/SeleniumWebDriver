package mailYandexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyUtil;

import java.util.Properties;

public class StartPage {
    private final WebDriver driver;
    @FindBy(xpath = "//button[contains(@class,'Login')]")
    WebElement LOGIN_BUTTON;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public StartPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("mail.yandex.url"));
        PageFactory.initElements(driver, this);
    }

    public LoginPage openLoginPage() {
        LOGIN_BUTTON.click();
        return new LoginPage(driver);
    }

    public WebElement getLoginButton() {
        return LOGIN_BUTTON;
    }
}
