package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import mailYandexTests.BaseTest;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.AlertPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmBoxTest extends BaseTest {
    private AlertPage alertPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "OpenConfirm")
    @Test
    @Description(value = "ТThe test verifies the opening of the ConfirmBox")
    public void verifyOpenConfirm() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getConfirmText(), "Press a button!", "Confirm did not open");
    }

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "CancelConfirm")
    @Test
    @Description(value = "The test checks if the ConfirmBox is closed")
    public void verifyCancelConfirm() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getConfirmBoxText(), "You pressed Cancel!", "Cancel button did not press");
    }
}
