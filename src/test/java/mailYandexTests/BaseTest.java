package mailYandexTests;

import org.junit.After;
import org.junit.Before;
import utils.singleton.LocalChromeDriver;

import java.time.Duration;

public class BaseTest {

    @Before
    public void setUp() {
        LocalChromeDriver.getInstance().manage().window().maximize();
        //Implicit waiter
        LocalChromeDriver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void closeChrome() {
        LocalChromeDriver.quit();
    }
}
