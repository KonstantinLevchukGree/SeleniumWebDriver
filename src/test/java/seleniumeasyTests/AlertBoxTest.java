package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import seleniumeasyPage.AlertPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertBoxTest extends BaseTest {
    private AlertPage alertPage;

    @Test
    public void verifyOpenAlert() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getAlertText(), "I am an alert box!", "Alert did not open");
    }
}
