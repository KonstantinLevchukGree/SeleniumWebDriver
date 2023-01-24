package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import seleniumeasyPage.AlertPage;
import utils.PropertyUtil;
import utils.singleton.LocalChromeDriver;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptBoxTest extends BaseTest {
    private AlertPage alertPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @Test
    public void verifyOpenPrompt() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getPromptInputText(), "Please enter your name", "Prompt did not open");
    }

    @Test
    public void verifyCancelConfirm() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getPromptBoxText(), "", "Cancel button did not press");
    }

    //Failed
    @Test
    public void verifyPromptAcceptMessage() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getPromptInputText(dataTests.getProperty("test.text")), dataTests.getProperty("test.text"), "Input text does not match prompt box text");
    }
}
