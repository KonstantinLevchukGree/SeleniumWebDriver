package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import mailYandexTests.BaseTest;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.LoadDataUserPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoadingDataUserTest extends BaseTest {
    private LoadDataUserPage userPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "DataUser")
    @Story(value = "LoadDataUser")
    @Test
    @Description(value = "The test checks the loading of data about the User")
    public void verifyLoadDataUser() {
        userPage = new LoadDataUserPage(LocalChromeDriver.getInstance());
        assertNotNull(userPage.getImageUser(), "Data user not loaded");
    }
}
