package seleniumeasyPage;

import modelUser.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TableSortSearchPage {
    private final WebDriver driver;
    private final By SELECT = By.xpath("//select[contains(@name,'example')]");
    private final By NEXT_BUTTON = By.id("example_next");
    private final By NUMBER_PAGES = By.xpath("//div[@id='example_paginate']//span//a");
    private final By ROWS_USERS = By.xpath("//table[@id='example']//tr[@class]");
    private final By COLUMN_NAME = By.xpath(".//td[1]");
    private final By COLUMN_POSITION = By.xpath(".//td[2]");
    private final By COLUMN_OFFICE = By.xpath(".//td[3]");
    private final By COLUMN_AGE = By.xpath(".//td[4]");
    private final By COLUMN_SALARY = By.xpath(".//td[6]");
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    public TableSortSearchPage(WebDriver driver) {
        this.driver = driver;
        driver.get(dataTests.getProperty("seleniumEasyTableUrl"));
    }

    private void selectOptionsDropdown(String selectEntries) {
        Select select = new Select(driver.findElement(SELECT));
        select.selectByValue(selectEntries);
    }

    private void clickNextButton() {
        if (!driver.findElement(By.xpath("//a[contains(@class,'button next')]")).getText().contains("disabled")) {
            WebElement nextButton = driver.findElement(NEXT_BUTTON);
            nextButton.click();
        }
    }

    public List<User> getUsersByAgeAndSalary(int minAgeUser, int maxSalaryUser, String selectEntries) {

        selectOptionsDropdown(selectEntries);

        List<User> userList = new ArrayList<>();

        for (int i = 0; i < driver.findElements(NUMBER_PAGES).size() - 1; i++) {

            List<WebElement> rowsList = driver.findElements(ROWS_USERS);

            for (WebElement element : rowsList) {

                int userAge = Integer.parseInt(element.findElement(COLUMN_AGE).getText());
                int salaryUser = Integer.parseInt(element.findElement(COLUMN_SALARY).getText()
                        .replace("$", "").replace(",", "").replace("/y", "").trim());

                if (userAge > minAgeUser & salaryUser < maxSalaryUser) {
                    User user = new User(
                            element.findElement(COLUMN_NAME).getText(),
                            element.findElement(COLUMN_POSITION).getText(),
                            element.findElement(COLUMN_OFFICE).getText(),
                            Integer.parseInt(element.findElement(COLUMN_AGE).getText()),
                            Integer.parseInt(element.findElement(COLUMN_SALARY).getText()
                                    .replace("$", "").replace(",", "").replace("/y", "").trim())
                    );
                    userList.add(user);
                }
            }
            clickNextButton();
        }
        return userList;
    }
}
