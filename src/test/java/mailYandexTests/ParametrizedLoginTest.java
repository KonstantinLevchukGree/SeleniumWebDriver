package mailYandexTests;

import io.qameta.allure.*;
import mailYandexPage.HomePage;
import mailYandexPage.LoginPage;
import mailYandexPage.StartPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.singleton.SingletonInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedLoginTest extends BaseTest {
    private StartPage startPage;

    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = "/userData.csv")
    @DisplayName("Test failed, After entered password required an SMS code")
    @Flaky
    @Description(value = "The test checks LogIn Users")
    @Epic(value = "Mail yandex")
    @Feature(value = "Authentication")
    @Story(value = "LogIn")
    @Issue(value = "FGY-3")
    public void verifyAuthentication(String userLogin, String UserPassword) {
        startPage = new StartPage(SingletonInstance.getInstance().getDriver());
        LoginPage loginPage = startPage.openLoginPage();
        HomePage homePage = loginPage.openHomePage(userLogin, UserPassword);
        assertEquals(homePage.getUserName(userLogin), userLogin, "LogIn to yandex mail failed");
    }
}