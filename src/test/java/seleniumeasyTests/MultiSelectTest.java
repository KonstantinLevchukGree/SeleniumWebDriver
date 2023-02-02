package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import mailYandexTests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.SelectPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultiSelectTest extends BaseTest {
    private SelectPage selectPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "MultiSelect")
    @Story(value = "SelectRandomOptions")
    @Test
    @DisplayName("Test failed, Get mote options that selected")
    @Description(value = "The test checks the random selection of options in Select")
    public void verifySelectRandomOptionsMultiSelect() {
        selectPage = new SelectPage(LocalChromeDriver.getInstance());
        assertEquals(selectPage.getSelectedOptions(), selectPage.getSelectRandomOptions());
    }
}
