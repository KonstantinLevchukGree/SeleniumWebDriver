import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartTest {
    SoftAssertions softly;
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

    @Before
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

        softly = new SoftAssertions();

        softly.assertThat(cart.getTotalPrice())
                .isNotEqualTo(null);

        softly.assertThat(cart.getTotalPrice())
                .isEqualTo(carPrice + diskPrice + (carPrice + diskPrice) * TAX);

        softly.assertAll();
    }

    @Test
    @Ignore("bug delete RealItem and VirtualItem methods")
    public void deleteRealItemAndVirtualItemFromCart() {

        cart.deleteRealItem(car);
        cart.deleteVirtualItem(disk);

        Assert.assertEquals(0, cart.getTotalPrice(), 0);
    }
}