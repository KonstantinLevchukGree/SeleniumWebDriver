package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By loginInput = By.id("passp-field-login");
    private By loginButton = By.id("passp:sign-in");
    private By passwordInput = By.id("passp-field-passwd");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputLogin(String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(loginButton));
       // driver.findElement(loginButton).click();
    }

    public void inputPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public HomePage openHomePage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(loginButton));

       // driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
