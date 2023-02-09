package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.ProgressBarPage;
import utils.singleton.SingletonInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgressBarTest {
    private ProgressBarPage progressBarPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "ProgressBar")
    @Story(value = "RefreshProgressBarPage")
    @Test
    @Description(value = "The test refreshes the page when the value in the ProgressBar is reached")
    public void verifyRefreshProgressBarPage() {
        progressBarPage = new ProgressBarPage(SingletonInstance.getInstance().getDriver());
        progressBarPage.stopProgressBarValueAndRefreshPage();
        assertEquals(0, progressBarPage.getPercentProgressBar(), "ProgressBarPage not refreshed");
    }

    @AfterEach
    public void closeChrome() {
        SingletonInstance.getInstance().quitAll();
    }
}
