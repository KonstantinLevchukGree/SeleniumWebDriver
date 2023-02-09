package mailYandexTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import testResultUtil.TestResultExtension;
import utils.singleton.SingletonInstance;

@ExtendWith(TestResultExtension.class)
public class BaseTest {
  /*  @BeforeEach
    public void setUp() {
        //Implicit waiter
        SingletonDriver.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }*/

    @AfterEach
    public void closeChrome() {
        SingletonInstance.getInstance().quitAll();
    }
}
