package page;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@AllArgsConstructor
public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By userMenuButton = By.xpath("//div[contains(@class,'User')]");
    private final String userNameLabel = "//div[contains(@class,'name')]/span[contains(text(),'%s')]";

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
