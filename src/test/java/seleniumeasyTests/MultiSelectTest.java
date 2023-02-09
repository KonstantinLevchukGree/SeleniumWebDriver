package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.SelectPage;
import utils.singleton.SingletonInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiSelectTest {
    private SelectPage selectPage;

    @Epic(value = "Selenium easy")
    @Feature(value = "MultiSelect")
    @Story(value = "SelectRandomOptions")
    @Test
    @DisplayName("Test failed, Get mote options that selected")
    @Description(value = "The test checks the random selection of options in Select")
    public void verifySelectRandomOptionsMultiSelect() {
        selectPage = new SelectPage(SingletonInstance.getInstance().getDriver());
        assertEquals(selectPage.getSelectedOptions(), selectPage.getSelectRandomOptions());
    }

    @AfterEach
    public void closeChrome() {
        SingletonInstance.getInstance().quitAll();
    }
}
