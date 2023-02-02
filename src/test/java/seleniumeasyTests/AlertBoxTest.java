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

public class AlertBoxTest extends BaseTest {
    private AlertPage alertPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "OpenAlert")
    @Test
    @Description(value = "The test checks for the opening of the AlertBox")
    public void verifyOpenAlert() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getAlertText(), "I am an alert box!", "Alert did not open");
    }
}
