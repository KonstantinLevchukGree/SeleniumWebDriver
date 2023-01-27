package seleniumeasyPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class SelectPage {
    private final WebDriver driver;
    @FindBy(id = "multi-select")
    WebElement multiSelect;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public SelectPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(dataTests.getProperty("select.dropdown.url"));
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSelectRandomOptions() {
        Select multiSelect = new Select(this.multiSelect);
        List<WebElement> list = multiSelect.getOptions();
        List<WebElement> selectOptions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < Integer.parseInt(dataTests.getProperty("number.options")); i++) {
            int randomOption = random.nextInt(list.size());
            selectOptions.add(list.get(randomOption));
            multiSelect.selectByIndex(randomOption);
        }
        return selectOptions;
    }

    public List<WebElement> getSelectedOptions() {
        Select multiSelect = new Select(this.multiSelect);
        return multiSelect.getAllSelectedOptions();
    }
}
