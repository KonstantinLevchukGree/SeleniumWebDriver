package mailYandexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScreenshotUtil;

public class LoginPage {
    private final WebDriver driver;
    @FindBy(id = "passp-field-login")
    WebElement loginInput;
    @FindBy(id = "passp:sign-in")
    WebElement loginButton;
    @FindBy(id = "passp-field-passwd")
    WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void inputLogin(String login) {
        loginInput.sendKeys(login);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    private void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public HomePage openHomePage(String login, String password) {
        inputLogin(login);
        clickLoginButton();
        inputPassword(password);
        clickLoginButton();
        ScreenshotUtil.getSnapShot();
        return new HomePage(driver);
    }
}
