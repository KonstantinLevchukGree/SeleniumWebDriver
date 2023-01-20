package seleniumeasyTests;

import mailYandexTests.BaseTest;
import org.junit.Test;
import seleniumeasyPage.SelectPage;
import utils.singleton.LocalChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultiSelectTest extends BaseTest {
    private SelectPage selectPage;

    @Test
    public void selectRandomOptionsMultiSelect() {

        selectPage = new SelectPage(LocalChromeDriver.getInstance());

      /*  List<WebElement> a = selectPage.getSelectRandomOptions();
        int sizeA = a.size();
        String a0 = selectPage.getSelectRandomOptions().get(0).getText();
        String a1 = selectPage.getSelectRandomOptions().get(1).getText();
        String a2 = selectPage.getSelectRandomOptions().get(2).getText();

        List<WebElement> b = selectPage.getSelectedOptions();
        int sizeB = b.size();
        String b0 = selectPage.getSelectedOptions().get(0).getText();
        String b1 = selectPage.getSelectedOptions().get(1).getText();
        String b2 = selectPage.getSelectedOptions().get(2).getText();
        String b3 = selectPage.getSelectedOptions().get(3).getText();
        int i = 0;*/

        //getSelectedOptions()-gets more options than selected. I think that multiSelection on the side of the web page is not working properly
        assertEquals(selectPage.getSelectedOptions(), selectPage.getSelectRandomOptions());
    }
}
