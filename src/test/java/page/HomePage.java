package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By userMenuButton = By.xpath("//div[contains(@class,'User')]");
    private final String userNameLabel = "//div[contains(@class,'name')]/span[contains(text(),'%s')]";

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private void openUserMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userMenuButton));
        driver.findElement(userMenuButton).click();
    }

    public String getUserName(String userName) {
        openUserMenu();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(userNameLabel, userName))));
        return driver.findElement(By.xpath(String.format(userNameLabel, userName))).getText().substring(0, userName.length());
    }
}
