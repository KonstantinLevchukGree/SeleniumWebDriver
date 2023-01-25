package seleniumeasyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

public class LoadDataUserPage {
    private final WebDriver driver;
    private final By GET_NEW_USER_BUTTON = By.id("save");
    private final By USER_IMAGE = By.xpath("//div[@id=\"loading\"]/img");

    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public LoadDataUserPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("load.user.url"));
    }

    public WebElement getImageUser() {
        driver.findElement(GET_NEW_USER_BUTTON).click();
        return new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time")))).until(ExpectedConditions.visibilityOfElementLocated(USER_IMAGE));
    }
}

