package mailYandexPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final By USER_MENU_BUTTON = By.xpath("//div[contains(@class,'User')]");
    private final String USER_NAME_LABEL = "//div[contains(@class,'name')]/span[contains(text(),'%s')]";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void openUserMenu() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(USER_MENU_BUTTON));
        driver.findElement(USER_MENU_BUTTON).click();
    }

    public String getUserName(String userName) {
        openUserMenu();
        Wait<WebDriver> fluentWaitwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1));
        fluentWaitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(USER_NAME_LABEL, userName))));
        return driver.findElement(By.xpath(String.format(USER_NAME_LABEL, userName))).getText().substring(0, userName.length());
    }
}
