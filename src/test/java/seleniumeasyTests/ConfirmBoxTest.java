package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.AlertPage;
import utils.singleton.SingletonInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmBoxTest {
    private AlertPage alertPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "OpenConfirm")
    @Test
    @Description(value = "ТThe test verifies the opening of the ConfirmBox")
    public void verifyOpenConfirm() {
        alertPage = new AlertPage(SingletonInstance.getInstance().getDriver());
        assertEquals(alertPage.getConfirmText(), "Press a button!", "Confirm did not open");
    }

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "CancelConfirm")
    @Test
    @Description(value = "The test checks if the ConfirmBox is closed")
    public void verifyCancelConfirm() {
        alertPage = new AlertPage(SingletonInstance.getInstance().getDriver());
        assertEquals(alertPage.getConfirmBoxText(), "You pressed Cancel!", "Cancel button did not press");
    }

    @AfterEach
    public void closeChrome() {
        SingletonInstance.getInstance().quitAll();
    }
}
