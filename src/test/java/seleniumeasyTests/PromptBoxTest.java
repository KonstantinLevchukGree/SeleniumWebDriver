package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import mailYandexTests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.AlertPage;
import utils.PropertyUtil;
import utils.singleton.LocalChromeDriver;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptBoxTest extends BaseTest {
    private AlertPage alertPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "OpenPrompt")
    @Test
    @Description(value = "The test checks to open the PromptBox")
    public void verifyOpenPrompt() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getPromptInputText(), "Please enter your name", "Prompt did not open");
    }

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "CancelConfirm")
    @Test
    @Description(value = "The test checks if the PromptBox is closed")
    public void verifyCancelConfirm() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getPromptBoxText(), "", "Cancel button did not press");
    }

    @Epic(value = "Selenium easy")
    @Feature(value = "Alert")
    @Story(value = "PromptAcceptMessage")
    @Test
    @DisplayName("Test failed, hint text is displayed in the entered text")
    @Description(value = "The test checks the entered text in the PromptBox")
    public void verifyPromptAcceptMessage() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getPromptInputText(dataTests.getProperty("test.text")), dataTests.getProperty("test.text"), "Input text does not match prompt box text");
    }
}
