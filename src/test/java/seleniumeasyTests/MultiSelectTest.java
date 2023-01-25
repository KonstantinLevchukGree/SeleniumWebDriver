package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import seleniumeasyPage.SelectPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultiSelectTest extends BaseTest {
    private SelectPage selectPage;

    @Test
    public void verifySelectRandomOptionsMultiSelect() {
        selectPage = new SelectPage(LocalChromeDriver.getInstance());
        assertEquals(selectPage.getSelectedOptions(), selectPage.getSelectRandomOptions());
    }
}
