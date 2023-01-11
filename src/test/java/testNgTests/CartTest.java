package testNgTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartTest {
    SoftAssert softAssert = new SoftAssert();
    private Cart cart;
    private RealItem car;
    private VirtualItem disk;
    private static final double TAX = 0.2;
    private final String cartName = "test-cart";
    private final String carName = "Nissan";
    private final double carWeight = 2000.2;
    private final int carPrice = 1000;
    private final String diskName = "WD400";
    private final int diskPrice = 50;
    private final int diskSize = 20000;

    @BeforeClass
    public void initCart() {

        cart = new Cart(cartName);

        car = new RealItem();
        car.setName(carName);
        car.setPrice(carPrice);
        car.setWeight(carWeight);

        cart.addRealItem(car);

        disk = new VirtualItem();
        disk.setName(diskName);
        disk.setPrice(diskPrice);
        disk.setSizeOnDisk(diskSize);

        cart.addVirtualItem(disk);
    }

    @Test
    public void checkTotalPriceCartTest() {
        softAssert.assertNotNull(cart.getTotalPrice(), "Total Price does not exist");
        softAssert.assertEquals(cart.getTotalPrice(), carPrice + diskPrice + (carPrice + diskPrice) * TAX, "Total Price not equal Total Price in test data");
        softAssert.assertAll("Soft assertions failed");
    }


    @Test(enabled = false, description = "Bug: delete RealItem and VirtualItem methods")
    public void deleteRealItemAndVirtualItemFromCart() {
        cart.deleteRealItem(car);
        cart.deleteVirtualItem(disk);
        Assert.assertEquals(cart.getTotalPrice(), 0, "RealItem or VirtualItem did not delete from Cart");
    }
}