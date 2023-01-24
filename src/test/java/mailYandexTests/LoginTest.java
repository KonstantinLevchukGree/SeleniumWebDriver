package mailYandexTests;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import mailYandexPage.HomePage;
import mailYandexPage.LoginPage;
import mailYandexPage.StartPage;
import utils.singleton.LocalChromeDriver;
import utils.PropertyUtil;

import java.util.Properties;

public class LoginTest extends BaseTest {
    private StartPage startPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @SneakyThrows
    @Test
    public void verifyAuthentication() {
        startPage = new StartPage(LocalChromeDriver.getInstance());
        //It is not a waiter. It looks like an Explicit waiter.
        Thread.sleep(5000);
        LoginPage loginPage = startPage.openLoginPage();
        HomePage homePage = loginPage.openHomePage(dataTests.getProperty("user.name"), dataTests.getProperty("user.password"));
        Assert.assertEquals(homePage.getUserName(dataTests.getProperty("user.name")), dataTests.getProperty("user.name"));
    }
}
