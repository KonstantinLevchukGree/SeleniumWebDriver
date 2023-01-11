package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By loginInput = By.id("passp-field-login");
    private final By loginButton = By.id("passp:sign-in");
    private final By passwordInput = By.id("passp-field-passwd");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private void inputLogin(String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    private void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public HomePage openHomePage(String login, String password) {
        inputLogin(login);
        clickLoginButton();
        inputPassword(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver, wait);
    }
}
