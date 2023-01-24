package seleniumeasyTests;

import mailYandexTests.BaseTest;
import modelUser.User;
import org.junit.Test;
import seleniumeasyPage.TableSortSearchPage;
import utils.PropertyUtil;
import utils.singleton.LocalChromeDriver;

import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableSortSearchTest extends BaseTest {
    private TableSortSearchPage tableSortSearchPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @Test
    public void verifyUsersByFilterFromTable() {
        tableSortSearchPage = new TableSortSearchPage(LocalChromeDriver.getInstance());
        List<User> listUsers = tableSortSearchPage.getUsersByAgeAndSalary();
        for (User listUser : listUsers) {
            assertTrue(listUser.getAgeUser() > Integer.parseInt(dataTests.getProperty("min.user.age"))
                            & listUser.getSalaryUser() < Integer.parseInt(dataTests.getProperty("max.user.salary"))
                    , "User age less input age or User salary more input salary");
        }
    }
}
