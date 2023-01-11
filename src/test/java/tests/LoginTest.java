package tests;

import org.junit.Assert;
import org.junit.Test;
import page.HomePage;
import page.LoginPage;
import utils.PropertyUtil;

import java.util.Properties;

public class LoginTest extends BaseTest {
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @Test
    public void authentication() {
        LoginPage loginPage = startPage.openLoginPage();

        HomePage homePage = loginPage.openHomePage(dataTests.getProperty("userName"), dataTests.getProperty("userPassword"));

        Assert.assertEquals(homePage.getUserName(dataTests.getProperty("userName")), dataTests.getProperty("userName"));
    }
}
