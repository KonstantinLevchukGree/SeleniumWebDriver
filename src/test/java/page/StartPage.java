package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public StartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private final By loginButton = By.xpath("//button[contains(@class,'Login')]");

    public LoginPage openLoginPage() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver, wait);
    }
}
