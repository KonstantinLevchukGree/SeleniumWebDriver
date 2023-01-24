package testNgTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.RealItem;

public class RealItemTest {
    private RealItem car;

    @Parameters({"weight car"})
    @BeforeClass(groups = {"group test"})
    public void initRealItem(String weightCar) {
        car = new RealItem();
        car.setWeight(Double.parseDouble(weightCar));
    }

    @Parameters({"weight car"})
    @Test(groups = {"group test"})
    public void checkWeightCar(String weightCar) {
        Assert.assertEquals(car.getWeight(), Double.parseDouble(weightCar), "Weight Car not equal Weight Car in test data");
    }
}
