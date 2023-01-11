package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static tests.BaseTest.wait;

public class LoginPage {
    private static WebDriver driver;
    private static final By loginInput = By.id("passp-field-login");
    private static final By loginButton = By.id("passp:sign-in");
    private static final By passwordInput = By.id("passp-field-passwd");

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
    }

    private static void inputLogin(String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    private static void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

    private static void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public HomePage openHomePage(String login, String password) {
        inputLogin(login);
        clickLoginButton();
        inputPassword(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
