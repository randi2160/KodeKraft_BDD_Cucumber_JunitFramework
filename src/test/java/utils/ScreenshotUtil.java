package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, Scenario scenarios){
        if(driver instanceof TakesScreenshot){
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot =ts.getScreenshotAs(OutputType.BYTES);
            scenarios.attach(screenshot,"image/png", "Screenshot");
        }
    }
}
