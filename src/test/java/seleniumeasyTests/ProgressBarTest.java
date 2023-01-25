package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import seleniumeasyPage.ProgressBarPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgressBarTest extends BaseTest {
    private ProgressBarPage progressBarPage;

    @Test
    public void verifyRefreshProgressBarPage() {
        progressBarPage = new ProgressBarPage(LocalChromeDriver.getInstance());
        progressBarPage.stopProgressBarValueAndRefreshPage();
        assertEquals(0, progressBarPage.getPercentProgressBar(), "ProgressBarPage not refreshed");
    }
}
