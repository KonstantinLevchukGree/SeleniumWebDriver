package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import seleniumeasyPage.AlertPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmBoxTest extends BaseTest {
    private AlertPage alertPage;

    @Test
    public void verifyOpenConfirm() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getConfirmText(), "Press a button!", "Confirm did not open");
    }

    @Test
    public void verifyCancelConfirm() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getConfirmBoxText(), "You pressed Cancel!", "Cancel button did not press");
    }
}
