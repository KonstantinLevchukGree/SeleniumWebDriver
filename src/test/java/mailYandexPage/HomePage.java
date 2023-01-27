package mailYandexPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

public class HomePage {
    private final WebDriver driver;
    @FindBy(xpath = "//div[contains(@class,'User')]")
    WebElement userMenuButton;
    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    WebElement logOutButton;
    private final String USER_NAME_LABEL = "//div[contains(@class,'name')]/span[contains(text(),'%s')]";
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickUserMenu() {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time"))))
                .until(ExpectedConditions.elementToBeClickable(userMenuButton));
        userMenuButton.click();
    }

    public String getUserName(String userName) {
        clickUserMenu();
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time"))))
                .pollingEvery(Duration.ofMillis(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(USER_NAME_LABEL, userName))));
        String userNameFromPage = driver.findElement(By.xpath(String.format(USER_NAME_LABEL, userName))).getText().substring(0, userName.length());
        clickUserMenu();
        return userNameFromPage;
    }

    public StartPage logOutUser() {
        clickUserMenu();
        logOutButton.click();
        return new StartPage(driver);
    }
}
