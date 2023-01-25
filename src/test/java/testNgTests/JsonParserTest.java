package testNgTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;

public class JsonParserTest {
    private Parser parser;
    private Cart cart;
    private Cart newCart;
    private final String cartName = "test-cart";
    private final String testCartName = "andrew-cart";
    private final String carName = "Nissan";
    private final String diskName = "WD400";
    private final double carWeight = 2000.2;
    private final int carPrice = 1000;
    private final int diskPrice = 50;
    private final int diskSize = 20000;

    @DataProvider(name = "checkWriteFromFileFileNegative", parallel = true)
    public Object[][] createData() {
        return new Object[][]{{"cart1"}, {"cart2"}, {"cart3"}, {"cart4"}, {"cart5"}};
    }

    @BeforeClass
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

    @Test()
    public void checkWriteFromFilePositive() {
        parser.writeToFile(cart);
        newCart = parser.readFromFile(new File("src/main/resources/" + cartName + ".json"));
        Assert.assertNotNull(newCart, "Failed to write the file");
    }

    @Test(dataProvider = "Data Provider and Parallel threads", expectedExceptions = {NoSuchFileException.class})
    public void checkWriteFromFileFileNegative(String notExistCartName) {
        parser.writeToFile(cart);
        newCart = parser.readFromFile(new File("src/main/resources/" + notExistCartName + ".json"));
        Assert.assertNull(newCart, "Successfully wrote the file");
    }

    @Test
    public void checkReadToFilePositive() {
        newCart = parser.readFromFile(new File("src/main/resources/" + testCartName + ".json"));
        Assert.assertNotNull(testCartName, "Failed to read the file");
    }

    @AfterClass
    public void clearJsonCartData() {
        File file = new File("src/main/resources/" + cartName + ".json");
        file.delete();
    }
}
