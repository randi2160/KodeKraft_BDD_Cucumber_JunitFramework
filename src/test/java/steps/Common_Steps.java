package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.ScreenshotUtil.takeScreenshot;

public class Common_Steps {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Fetch browser and headless mode from system properties, defaulting to Chrome and headless mode enabled
        String browser = System.getProperty("browser", "chrome"); // Default to Chrome
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true")); // Default headless to true
        // Use the internal Docker network to connect to Selenium Grid via its container name
        String gridUrl = System.getProperty("selenium.grid.url", "http://localhost:4444"); // Default Grid URL

        int retryCount = 0;
        int maxRetries = 3;
        boolean driverInitialized = false;

        while (retryCount < maxRetries && !driverInitialized) {
            try {
                // Create a URL object using the Selenium Grid URL
                URL remoteGridUrl = new URL(gridUrl);
                System.out.println("Connecting to Selenium Grid at: " + remoteGridUrl);

                // Browser setup logic based on the browser choice
                switch (browser.toLowerCase()) {
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        if (isHeadless) {
                            firefoxOptions.addArguments("--headless");
                        }
                        driver = new RemoteWebDriver(remoteGridUrl, firefoxOptions); // Connect to Grid
                        break;

                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        if (isHeadless) {
                            edgeOptions.addArguments("--headless");
                        }
                        driver = new RemoteWebDriver(remoteGridUrl, edgeOptions); // Connect to Grid
                        break;

                    case "chrome":
                    default:
                        ChromeOptions chromeOptions = new ChromeOptions();
                        if (isHeadless) {
                            chromeOptions.addArguments("--headless");
                        }
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.addArguments("--window-size=1920,1080");
                        chromeOptions.addArguments("--remote-allow-origins=*"); // Fix for certain Chrome versions
                        driver = new RemoteWebDriver(remoteGridUrl, chromeOptions); // Connect to Grid
                        break;
                }

                System.out.println("Connected to Selenium Grid with browser: " + browser);
                driverInitialized = true;

            } catch (MalformedURLException e) {
                System.err.println("Grid URL is invalid: " + e.getMessage());
            } catch (Exception e) {
                retryCount++;
                System.err.println("Error initializing WebDriver, retrying (" + retryCount + "/" + maxRetries + "): " + e.getMessage());
                if (retryCount == maxRetries) {
                    throw new RuntimeException("Failed to initialize WebDriver after " + maxRetries + " attempts.");
                }
            }
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                if (driver instanceof TakesScreenshot) {
                    try {
                        takeScreenshot(driver, scenario); // Custom screenshot utility method
                        System.out.println("Screenshot taken for failed scenario: " + scenario.getName());
                    } catch (Exception e) {
                        System.err.println("Error while taking screenshot: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error during scenario teardown: " + e.getMessage());
        } finally {
            if (driver != null) {
                try {
                    driver.quit();
                    System.out.println("Browser session ended.");
                } catch (Exception e) {
                    System.err.println("Error while quitting the driver: " + e.getMessage());
                }
            }
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
        return driver;
    }
}
