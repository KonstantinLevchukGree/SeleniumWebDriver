package mailYandexTests;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import testResultUtil.TestResultExtension;
import utils.singleton.LocalChromeDriver;

import java.time.Duration;
@ExtendWith(TestResultExtension.class)
public class BaseTest {
    @Before
    public void setUp() {
        LocalChromeDriver.getInstance().manage().window().maximize();
        //Implicit waiter
        LocalChromeDriver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void closeChrome() {
        LocalChromeDriver.quit();
    }
}
