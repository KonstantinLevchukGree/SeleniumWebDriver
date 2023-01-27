package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import seleniumeasyPage.SelectPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultiSelectTest extends BaseTest {
    private SelectPage selectPage;

    @Test
    @Disabled
    @DisplayName("Test failed, Get mote options that selected")
    public void verifySelectRandomOptionsMultiSelect() {
        selectPage = new SelectPage(LocalChromeDriver.getInstance());
        assertEquals(selectPage.getSelectedOptions(), selectPage.getSelectRandomOptions());
    }
}
