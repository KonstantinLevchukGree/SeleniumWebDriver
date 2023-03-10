package seleniumeasyTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelUser.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seleniumeasyPage.TableSortSearchPage;
import utils.PropertyUtil;
import utils.singleton.SingletonInstance;

import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableSortSearchTest {
    private TableSortSearchPage tableSortSearchPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @Epic(value = "Selenium easy")
    @Feature(value = "Table")
    @Story(value = "UsersByFilterFromTable")
    @Test
    @Description(value = "The test checks the Users filter")
    public void verifyUsersByFilterFromTable() {
        tableSortSearchPage = new TableSortSearchPage(SingletonInstance.getInstance().getDriver());
        List<User> listUsers = tableSortSearchPage.getUsersByAgeAndSalary();
        for (User listUser : listUsers) {
            assertTrue(listUser.getAgeUser() > Integer.parseInt(dataTests.getProperty("min.user.age"))
                            & listUser.getSalaryUser() < Integer.parseInt(dataTests.getProperty("max.user.salary"))
                    , "User age less input age or User salary more input salary");
        }
    }
    @AfterEach
    public void closeChrome() {
        SingletonInstance.getInstance().quitAll();
    }
}
