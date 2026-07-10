package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class ScreenshotUtils {

    public static void capture(WebDriver driver,String testName){

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        File destination = new File("screenshots/"+ testName+ ".png");
        source.renameTo(destination);
    }
}