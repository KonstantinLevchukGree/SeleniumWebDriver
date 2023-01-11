package seleniumWebDriverTests;

import org.junit.Assert;
import org.junit.Test;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends BaseTest {
    //properties
    private String userName = "konstantinliauchuk";
    private String userPassword = "11436811a";

    @Test
    public void authentication() {
        LoginPage loginPage = startPage.openLoginPage();
        loginPage.inputLogin(userName);
        loginPage.clickLoginButton();
        loginPage.inputPassword(userPassword);
        HomePage homePage = loginPage.openHomePage();
        homePage.openUserMenu();
        Assert.assertEquals(homePage.getUserName(userName),userName);
    }
}
