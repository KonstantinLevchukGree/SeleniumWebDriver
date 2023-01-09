package jUnitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shop.VirtualItem;

public class VirtualItemTest {
    private final int diskSize = 20000;
    private VirtualItem virtualItem;

    @Before
    public void initVirtualItem() {
        virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(diskSize);
    }

    @Test
    public void checkDiskSize() {
        Assert.assertEquals(diskSize, virtualItem.getSizeOnDisk(), 0);
    }
}
