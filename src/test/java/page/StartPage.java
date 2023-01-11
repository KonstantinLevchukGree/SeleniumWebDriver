package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static tests.BaseTest.wait;

public class StartPage {
    private static WebDriver driver;
    private static final By loginButton = By.xpath("//button[contains(@class,'Login')]");

    public StartPage(WebDriver driver) {
        StartPage.driver = driver;
    }

    public LoginPage openLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
