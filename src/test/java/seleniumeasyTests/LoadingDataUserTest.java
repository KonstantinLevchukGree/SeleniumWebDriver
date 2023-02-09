package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.LoadDataUserPage;
import utils.singleton.SingletonInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoadingDataUserTest {
    private LoadDataUserPage userPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "DataUser")
    @Story(value = "LoadDataUser")
    @Test
    @Description(value = "The test checks the loading of data about the User")
    public void verifyLoadDataUser() {
        userPage = new LoadDataUserPage(SingletonInstance.getInstance().getDriver());
        assertNotNull(userPage.getImageUser(), "Data user not loaded");
    }

    @AfterEach
    public void closeChrome() {
        SingletonInstance.getInstance().quitAll();
    }
}
