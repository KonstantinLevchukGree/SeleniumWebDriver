package seleniumeasyPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

public class AlertPage {
    private final WebDriver driver;
    @FindBy(xpath = "//button[contains(@onclick,'Alert')]")
    WebElement ALERT_BUTTON;
    @FindBy(xpath = "//button[contains(@onclick,'Confirm')]")
    WebElement CONFIRM_BUTTON;
    @FindBy(xpath = "//button[contains(@onclick,'Prompt')]")
    WebElement PROMPT_BUTTON;
    @FindBy(id = "confirm-demo")
    WebElement CONFIRM_BOX_TEXT;
    @FindBy(id = "prompt-demo")
    WebElement PROMPT_BOX_TEXT;

    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("js.alert.url"));
        PageFactory.initElements(driver, this);
    }

    private Alert openAlertAndWait(WebElement webElement) {
        webElement.click();
        return new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time")))).until(ExpectedConditions.alertIsPresent());
    }

    private String getAlertTextAndAccept(WebElement webElement) {
        Alert alert = openAlertAndWait(webElement);
        String text = alert.getText();
        alert.accept();
        return text;
    }

    private String getAlertTextAndDismiss(WebElement webElement) {
        Alert alert = openAlertAndWait(webElement);
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
        return CONFIRM_BOX_TEXT.getText();
    }

    public String getPromptInputText() {
        return getAlertTextAndDismiss(PROMPT_BUTTON);
    }

    public String getPromptBoxText() {
        Alert alert = openAlertAndWait(PROMPT_BUTTON);
        alert.dismiss();
        return PROMPT_BOX_TEXT.getText();
    }

    public String getPromptInputText(String text) {
        Alert alert = openAlertAndWait(PROMPT_BUTTON);
        alert.sendKeys(text);
        alert.accept();
        return PROMPT_BOX_TEXT.getText();
    }
}
