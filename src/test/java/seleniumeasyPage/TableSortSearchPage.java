package seleniumeasyPage;

import modelUser.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TableSortSearchPage {
    private final WebDriver driver;
    @FindBy(xpath = "//select[contains(@name,'example')]")
    WebElement entriesSelect;
    @FindBy(id = "example_next")
    WebElement nextButton;
    @FindBy(xpath = "//div[@id='example_paginate']//span//a")
    List<WebElement> numberPages;
    @FindBy(xpath = "//table[@id='example']//tr[@class]")
    List<WebElement> rowsUsers;
    private final By COLUMN_NAME = By.xpath(".//td[1]");
    private final By COLUMN_POSITION = By.xpath(".//td[2]");
    private final By COLUMN_OFFICE = By.xpath(".//td[3]");
    private final By COLUMN_AGE = By.xpath(".//td[4]");
    private final By COLUMN_SALARY = By.xpath(".//td[6]");
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public TableSortSearchPage(WebDriver driver) {
        this.driver = driver;
        driver.get(dataTests.getProperty("table.url"));
        PageFactory.initElements(driver, this);
    }

    private void selectOptionsDropdown(String selectEntries) {
        Select select = new Select(this.entriesSelect);
        select.selectByValue(selectEntries);
    }

    private void clickNextButton() {
        if (!driver.findElement(By.xpath("//a[contains(@class,'button next')]"))
                .getText().contains("disabled")) {
            nextButton.click();
        }
    }

    public List<User> getUsersByAgeAndSalary() {
        selectOptionsDropdown(dataTests.getProperty("select.entries"));
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < numberPages.size() - 1; i++) {
            List<WebElement> rowsList = rowsUsers;
            for (WebElement element : rowsList) {
                int userAge = Integer.parseInt(element.findElement(COLUMN_AGE).getText());
                int salaryUser = Integer.parseInt(element.findElement(COLUMN_SALARY).getText()
                        .replace("$", "").replace(",", "")
                        .replace("/y", "").trim());
                if (userAge > Integer.parseInt(dataTests.getProperty("min.user.age"))
                        & salaryUser < Integer.parseInt(dataTests.getProperty("max.user.salary"))) {
                    User user = new User(
                            element.findElement(COLUMN_NAME).getText(),
                            element.findElement(COLUMN_POSITION).getText(),
                            element.findElement(COLUMN_OFFICE).getText(),
                            Integer.parseInt(element.findElement(COLUMN_AGE).getText()),
                            Integer.parseInt(element.findElement(COLUMN_SALARY).getText()
                                    .replace("$", "")
                                    .replace(",", "")
                                    .replace("/y", "").trim())
                    );
                    userList.add(user);
                }
            }
            clickNextButton();
        }
        return userList;
    }
}
