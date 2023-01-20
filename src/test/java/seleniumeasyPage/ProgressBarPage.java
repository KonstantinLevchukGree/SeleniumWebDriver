package seleniumeasyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyUtil;

import java.util.Properties;

public class ProgressBarPage {
    private final WebDriver driver;
    private final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    private final By PERCENT_PROGRESS_BAR = By.xpath("//div[contains(@class,'percent')]");
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("seleniumEasyProgressBarUrl"));
    }

    public int getPercentProgressBar() {
        driver.findElement(DOWNLOAD_BUTTON).click();
        int percentProgressBar= 0;
        while (Integer.parseInt(driver.findElement(PERCENT_PROGRESS_BAR).getText().replace("%","").trim()) <= Integer.parseInt(dataTests.getProperty("percentProgressBar"))) {

            percentProgressBar=Integer.parseInt(driver.findElement(PERCENT_PROGRESS_BAR).getText().replace("%","").trim());

            if(percentProgressBar>Integer.parseInt(dataTests.getProperty("percentProgressBar"))){
                driver.navigate().refresh();
                break;
            }
        }
        return percentProgressBar;
    }
}
