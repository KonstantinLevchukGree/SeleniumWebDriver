package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import seleniumeasyPage.LoadDataUserPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoadingDataUserTest extends BaseTest {
    private LoadDataUserPage userPage;

    @Test
    public void verifyLoadUser() {
        userPage = new LoadDataUserPage(LocalChromeDriver.getInstance());
        assertNotNull(userPage.getImageUser(), "Data user not loaded");
    }
}
