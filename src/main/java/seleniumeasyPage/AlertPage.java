package seleniumeasyPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtil;
import utils.ScreenShotUtil;

import java.time.Duration;
import java.util.Properties;

public class AlertPage {
    private final WebDriver driver;
    @FindBy(xpath = "//button[contains(@onclick,'Alert')]")
    WebElement alertButton;
    @FindBy(xpath = "//button[contains(@onclick,'Confirm')]")
    WebElement confirmButton;
    @FindBy(xpath = "//button[contains(@onclick,'Prompt')]")
    WebElement promptButton;
    @FindBy(id = "confirm-demo")
    WebElement confirmBoxText;
    @FindBy(id = "prompt-demo")
    WebElement promptBoxText;

    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("js.alert.url"));
        PageFactory.initElements(driver, this);
    }

    private Alert openAlertAndWait(WebElement webElement) {
        webElement.click();
        return new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(dataTests.getProperty("explicit.time"))))
                .until(ExpectedConditions.alertIsPresent());
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
        return getAlertTextAndAccept(alertButton);
    }

    public String getConfirmText() {
        return getAlertTextAndDismiss(confirmButton);
    }

    public String getConfirmBoxText() {
        Alert alert = openAlertAndWait(confirmButton);
        alert.dismiss();
        return confirmBoxText.getText();
    }

    public String getPromptInputText() {
        return getAlertTextAndDismiss(promptButton);
    }

    public String getPromptBoxText() {
        Alert alert = openAlertAndWait(promptButton);
        alert.dismiss();
        return promptBoxText.getText();
    }

    public String getPromptInputText(String text) {
        Alert alert = openAlertAndWait(promptButton);
        alert.sendKeys(text);
        alert.accept();
        return promptBoxText.getText();
    }
}
