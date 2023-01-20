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
    public void getUserByFilter() {

        tableSortSearchPage = new TableSortSearchPage(LocalChromeDriver.getInstance());

        List<User> listUsers = tableSortSearchPage.getUsersByAgeAndSalary(Integer.parseInt(dataTests.getProperty("minUserAge"))
                , Integer.parseInt(dataTests.getProperty("maxUserSalary"))
                , dataTests.getProperty("selectEntries"));

        for (User listUser : listUsers) {
            assertTrue(listUser.getAgeUser() > Integer.parseInt(dataTests.getProperty("minUserAge"))
                            & listUser.getSalaryUser() < Integer.parseInt(dataTests.getProperty("maxUserSalary"))
                    , "User age less input age or User salary more input salary");
        }
    }
}
