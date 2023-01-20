package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import seleniumeasyPage.ProgressBarPage;
import utils.PropertyUtil;
import utils.singleton.LocalChromeDriver;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgressBarTest extends BaseTest {
    private ProgressBarPage progressBarPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @Test
    public void refreshProgressBar() {
        progressBarPage = new ProgressBarPage(LocalChromeDriver.getInstance());
        assertTrue(progressBarPage.getPercentProgressBar() >= Integer.parseInt(dataTests.getProperty("percentProgressBar")), "ProgressBarPage not refreshed");
    }
}
