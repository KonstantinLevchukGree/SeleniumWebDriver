package seleniumeasyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

public class LoadDataUserPage {
    private final WebDriver driver;
    @FindBy(id = "save")
    WebElement getNewUserButton;
    @FindBy(xpath = "//div[@id=\"loading\"]/img")
    WebElement userImage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public LoadDataUserPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("load.user.url"));
        PageFactory.initElements(driver, this);
    }

    public WebElement getImageUser() {
        getNewUserButton.click();
        return new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time")))).until(ExpectedConditions.visibilityOf(userImage));
    }
}

