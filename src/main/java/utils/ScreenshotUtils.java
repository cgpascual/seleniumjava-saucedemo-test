package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String path = "screenshots/" + testName + "_" + timestamp + ".png";

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {

            Files.copy(
                    source.toPath(),
                    new File(path).toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {

            e.printStackTrace();

        }

        return path;
    }

}