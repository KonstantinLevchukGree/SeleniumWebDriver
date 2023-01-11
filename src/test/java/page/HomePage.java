package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    //
    private By userMenuButton = By.xpath("//div[contains(@class,'User')]");
    private String userNameLabel = "//div[contains(@class,'name')]/span[contains(text(),'%s')]";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUserMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userMenuButton));
        driver.findElement(userMenuButton).click();
    }

    public String getUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(userNameLabel, userName))));
        return driver.findElement(By.xpath(String.format(userNameLabel, userName))).getText().substring(0, userName.length());
    }
}
