package mailYandexTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import mailYandexPage.HomePage;
import mailYandexPage.LoginPage;
import mailYandexPage.StartPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedLoginTest extends BaseTest {
    private StartPage startPage;

    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = "/userData.csv")
    @DisplayName("Test failed, After entered password required an SMS code")
    public void verifyAuthentication(String userLogin, String UserPassword) {
        startPage = new StartPage(LocalChromeDriver.getInstance());
        LoginPage loginPage = startPage.openLoginPage();
        HomePage homePage = loginPage.openHomePage(userLogin, UserPassword);
        assertEquals(homePage.getUserName(userLogin), userLogin, "LogIn to yandex mail failed");
    }
}