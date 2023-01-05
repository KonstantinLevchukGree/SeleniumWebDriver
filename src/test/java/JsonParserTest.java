import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class JsonParserTest {

    @Parameterized.Parameters
    public static Iterable<? extends Object> data() {
        return Arrays.asList("cart1", "cart2", "cart3", "cart4", "cart5");
    }

    private Parser parser;
    private Cart cart;
    private Cart newCart;
    @Parameterized.Parameter
    public String notExistCartName;
    private final String cartName = "test-cart";
    private final String carName = "Nissan";
    private final String diskName = "WD400";
    private final double carWeight = 2000.2;
    private final int carPrice = 1000;
    private final int diskPrice = 50;
    private final int diskSize = 20000;

    @Before
    public void initJsonParserAndCart() {

        parser = new JsonParser();
        cart = new Cart(cartName);

        RealItem car = new RealItem();
        car.setName(carName);
        car.setPrice(carPrice);
        car.setWeight(carWeight);

        cart.addRealItem(car);

        VirtualItem disk = new VirtualItem();
        disk.setName(diskName);
        disk.setPrice(diskPrice);
        disk.setSizeOnDisk(diskSize);

        cart.addVirtualItem(disk);
    }

    @Test
    public void checkReadFromFilePositiveTest() {
        parser.writeToFile(cart);
        newCart = parser.readFromFile(new File("src/main/resources/" + cartName + ".json"));
        Assert.assertNotNull(newCart);
    }

    @Test(expected = NoSuchFileException.class)
    public void checkReadFromFileFileNegativeTest() {
        parser.writeToFile(cart);
        newCart = parser.readFromFile(new File("src/main/resources/" + notExistCartName + ".json"));
        Assert.assertNotNull(newCart);
    }

    @Test
    public void checkWriteToFileTest() {
        parser.writeToFile(cart);
        newCart = parser.readFromFile(new File("src/main/resources/" + cartName + ".json"));
        Assert.assertNotNull(newCart);
    }

    @After
    public void clearJsonCartData() {
        File file = new File("src/main/resources/" + cartName + ".json");
        file.delete();
    }
}
