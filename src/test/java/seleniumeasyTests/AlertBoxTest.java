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

public class AlertBoxTest {
    private AlertPage alertPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "OpenAlert")
    @Test
    @Description(value = "The test checks for the opening of the AlertBox")
    public void verifyOpenAlert() {
        alertPage = new AlertPage(SingletonInstance.getInstance().getDriver());
        assertEquals(alertPage.getAlertText(), "I am an alert box!", "Alert did not open");
    }

    @AfterEach
    public void closeChrome() {
        SingletonInstance.getInstance().quitAll();
    }
}
