package seleniumeasyTests;

import modelUser.User;
import org.junit.Test;
import seleniumeasyPage.TableSortSearchPage;
import utils.PropertyUtil;
import utils.singleton.LocalChromeDriver;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableSortSearchTest {
    private TableSortSearchPage tableSortSearchPage;
    private final Properties dataTests = PropertyUtil.getProperties("testsData.properties");

    @Test
    public void openAlert() {

        tableSortSearchPage = new TableSortSearchPage(LocalChromeDriver.getInstance());

        List<User> listUsers = tableSortSearchPage.getUsersByAgeAndSalary(Integer.parseInt(dataTests.getProperty("minUserAge")), Integer.parseInt(dataTests.getProperty("maxUserSalary")));

        User randomUserFromList = listUsers.get(new Random().nextInt(listUsers.size()));

        assertTrue(randomUserFromList.getAgeUser() > Integer.parseInt(dataTests.getProperty("minUserAge")), "User age less input age ");
        assertTrue(randomUserFromList.getSalaryUser() < Integer.parseInt(dataTests.getProperty("maxUserSalary")), "User salary more input salary");
    }
}
