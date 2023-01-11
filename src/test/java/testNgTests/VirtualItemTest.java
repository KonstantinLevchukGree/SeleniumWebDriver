package testNgTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.VirtualItem;

public class VirtualItemTest {
    private VirtualItem virtualItem;

    @Parameters({"disk size"})
    @BeforeClass(groups = {"group test"})
    public void initVirtualItem(String diskSizeDataTest) {
        virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(Double.parseDouble(diskSizeDataTest));
    }

    @Parameters({"disk size"})
    @Test(groups = {"group test"})
    public void checkDiskSize(String diskSizeDataTest) {
        Assert.assertEquals(virtualItem.getSizeOnDisk(), Double.parseDouble(diskSizeDataTest), "Size Disk not equal Size Disk in test data");
    }
}
