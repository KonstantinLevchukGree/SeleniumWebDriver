package mailYandexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;
    @FindBy(id = "passp-field-login")
    WebElement LOGIN_INPUT;
    @FindBy(id = "passp:sign-in")
    WebElement LOGIN_BUTTON;
    @FindBy(id = "passp-field-passwd")
    WebElement PASSWORD_INPUT;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void inputLogin(String login) {
        LOGIN_INPUT.sendKeys(login);
    }

    private void clickLoginButton() {
        LOGIN_BUTTON.click();
    }

    private void inputPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
    }

    public HomePage openHomePage(String login, String password) {
        inputLogin(login);
        clickLoginButton();
        inputPassword(password);
        clickLoginButton();
        return new HomePage(driver);
    }
}
