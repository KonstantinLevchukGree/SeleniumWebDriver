package seleniumeasyPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

public class AlertPage {
    private final WebDriver driver;
    private final By ALERT_BUTTON = By.xpath("//button[contains(@onclick,'Alert')]");
    private final By CONFIRM_BUTTON = By.xpath("//button[contains(@onclick,'Confirm')]");
    private final By PROMPT_BUTTON = By.xpath("//button[contains(@onclick,'Prompt')]");
    private final By CONFIRM_BOX_TEXT = By.id("confirm-demo");
    private final By PROMPT_BOX_TEXT = By.id("prompt-demo");
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("js.alert.url"));
    }

    private Alert openAlertAndWait(By by) {
        driver.findElement(by).click();
        return new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time")))).until(ExpectedConditions.alertIsPresent());
    }

    private String getAlertTextAndAccept(By by) {
        Alert alert = openAlertAndWait(by);
        String text = alert.getText();
        alert.accept();
        return text;
    }

    private String getAlertTextAndDismiss(By by) {
        Alert alert = openAlertAndWait(by);
        String text = alert.getText();
        alert.dismiss();
        return text;
    }

    public String getAlertText() {
        return getAlertTextAndAccept(ALERT_BUTTON);
    }

    public String getConfirmText() {
        return getAlertTextAndDismiss(CONFIRM_BUTTON);
    }

    public String getConfirmBoxText() {
        Alert alert = openAlertAndWait(CONFIRM_BUTTON);
        alert.dismiss();
        return driver.findElement(CONFIRM_BOX_TEXT).getText();
    }

    public String getPromptInputText() {
        return getAlertTextAndDismiss(PROMPT_BUTTON);
    }

    public String getPromptBoxText() {
        Alert alert = openAlertAndWait(PROMPT_BUTTON);
        alert.dismiss();
        return driver.findElement(PROMPT_BOX_TEXT).getText();
    }

    public String getPromptInputText(String text) {
        Alert alert = openAlertAndWait(PROMPT_BUTTON);
        alert.sendKeys(text);
        alert.accept();
        return driver.findElement(PROMPT_BOX_TEXT).getText();
    }
}
