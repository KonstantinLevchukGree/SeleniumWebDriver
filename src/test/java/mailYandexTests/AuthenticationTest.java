package mailYandexTests;

import mailYandexPage.HomePage;
import mailYandexPage.LoginPage;
import mailYandexPage.StartPage;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import utils.PropertyUtil;
import utils.singleton.LocalChromeDriver;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationTest extends BaseTest {
    private StartPage startPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");
    @Disabled
    @DisplayName("Test failed, After entered password required an SMS code")
    @Order(1)
    @Test
    public void verifyLogIn() {
        startPage = new StartPage(LocalChromeDriver.getInstance());
        LoginPage loginPage = startPage.openLoginPage();
        HomePage homePage = loginPage.openHomePage(dataTests.getProperty("user.name"), dataTests.getProperty("user.password"));
        assertEquals(homePage.getUserName(dataTests.getProperty("user.name")), dataTests.getProperty("user.name"), "LogIn to yandex mail failed");
    }

    @Disabled
    @DisplayName("Test failed, After entered password required an SMS code")
    @Order(2)
    @Test
    public void verifyLogOut() {
        startPage = new StartPage(LocalChromeDriver.getInstance());
        LoginPage loginPage = startPage.openLoginPage();
        HomePage homePage = loginPage.openHomePage(dataTests.getProperty("user.name"), dataTests.getProperty("user.password"));
        startPage = homePage.logOutUser();
        assertTrue(startPage.getLoginButton().isDisplayed(), "Logout from yandex mail failed");
    }
}
