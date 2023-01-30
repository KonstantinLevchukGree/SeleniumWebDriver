package utils;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.singleton.LocalChromeDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    @SneakyThrows
    public static void getSnapShot() {
        TakesScreenshot scrShot = ((TakesScreenshot) LocalChromeDriver.getInstance());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("src/test/java/screenshots/" + " "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss")) + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
