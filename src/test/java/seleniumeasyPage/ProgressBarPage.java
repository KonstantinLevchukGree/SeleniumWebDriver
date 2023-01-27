package seleniumeasyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtil;
import utils.singleton.LocalChromeDriver;

import java.time.Duration;
import java.util.Properties;
import java.util.regex.Pattern;

public class ProgressBarPage {
    private final WebDriver driver;

    @FindBy(id = "cricle-btn")
    WebElement downloadButton;
    private final By PERCENT_PROGRESS_BAR = By.xpath("//div[contains(@class,'percent')]");
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("progress.bar.url"));
        PageFactory.initElements(driver, this);
    }

    private void startProgressBar() {
        downloadButton.click();
    }

    public int getPercentProgressBar() {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time"))))
                .until(ExpectedConditions.visibilityOfElementLocated(PERCENT_PROGRESS_BAR));
        return Integer.parseInt(LocalChromeDriver.getInstance().findElement(PERCENT_PROGRESS_BAR).getText().replace("%", "")
                .trim());
    }

    public void stopProgressBarValueAndRefreshPage() {
        startProgressBar();
        Pattern pattern = Pattern.compile("[5-9](\\d{1})");
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time.progress.bar"))))
                .until(ExpectedConditions.textMatches(PERCENT_PROGRESS_BAR, pattern));
        driver.navigate().refresh();
    }
}


