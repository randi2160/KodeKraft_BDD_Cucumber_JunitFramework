package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v114.audits.model.BounceTrackingIssueDetails;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.ScreenshotUtil.takeScreenshot;

public class Common_Steps {
    private WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome"); // Default to Chrome if no browser is specified
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true")); // Default to true, turn false if debugging

        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "ie":
            case "internetexplorer":
                driver = new InternetExplorerDriver();
                break;

            case "edge":
            case "chromium":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            takeScreenshot(driver,scenario);
        }
        if (driver != null) {
            driver.quit();
        }
    }



    /*  private void takeScreenshot(Scenario scenarios){
          if(driver instanceof TakesScreenshot){
              TakesScreenshot ts = (TakesScreenshot) driver;
              byte[] screenshot =ts.getScreenshotAs(OutputType.BYTES);
              scenarios.attach(screenshot,"image/png", "Screenshot");
          }
      }
  */
    public WebDriver getDriver() {
        return driver;
    }
}
