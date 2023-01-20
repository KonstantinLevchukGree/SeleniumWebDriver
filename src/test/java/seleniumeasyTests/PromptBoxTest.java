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
    public void openPrompt() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getPromptText(), "Please enter your name", "Prompt did not open");
    }

    @Test
    public void clickCancelConfirm() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.getPromptBoxText(), "", "Cancel button did not press");
    }

    //Failed
    @Test
    public void inputTextPrompt() {
        alertPage = new AlertPage(LocalChromeDriver.getInstance());
        assertEquals(alertPage.inputPromptText(dataTests.getProperty("test")), dataTests.getProperty("test"), "Input text does not match prompt box text");
    }
}
