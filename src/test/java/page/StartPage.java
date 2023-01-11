package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {
    private WebDriver driver;
    private By loginButton = By.xpath("//button[contains(@class,'Login')]");

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
