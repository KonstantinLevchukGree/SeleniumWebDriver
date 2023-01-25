package mailYandexPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By LOGIN_INPUT = By.id("passp-field-login");
    private final By LOGIN_BUTTON = By.id("passp:sign-in");
    private final By PASSWORD_INPUT = By.id("passp-field-passwd");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void inputLogin(String login) {
        driver.findElement(LOGIN_INPUT).sendKeys(login);
    }

    private void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    private void inputPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public HomePage openHomePage(String login, String password) {
        inputLogin(login);
        clickLoginButton();
        inputPassword(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}
