package jUnitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shop.RealItem;

public class RealItemTest {
    private final String carName = "Nissan";
    private final int carPrice = 1000;
    private final double weightCar = 2000.2;
    private RealItem car;

    @Before
    public void initRealItem() {
        car = new RealItem();
        car.setName(carName);
        car.setPrice(carPrice);
        car.setWeight(weightCar);
    }

    @Test
    public void checkWeightCarTest() {
        Assert.assertEquals(weightCar, car.getWeight(), 0);
    }
}
