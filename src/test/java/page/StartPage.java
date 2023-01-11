package page;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@AllArgsConstructor
public class StartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By loginButton = By.xpath("//button[contains(@class,'Login')]");

    public LoginPage openLoginPage() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver, wait);
    }
}
