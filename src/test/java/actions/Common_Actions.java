package actions;

import elements.EbayHome_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import steps.Common_Steps;

public class Common_Actions {
    private WebDriver driver;
    private EbayHome_Elements ebayHomeElements;

    public Common_Actions(Common_Steps common_steps) {
        this.driver = common_steps.getDriver();
        ebayHomeElements = new EbayHome_Elements(driver);
        PageFactory.initElements(driver, ebayHomeElements); // Initialize elements with PageFactory
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void quitWebDriver() {
        driver.quit();
    }

    public int getSearchItemsCount() {
        String itemCount = ebayHomeElements.searchResultsCount.getText().trim();
        String itemCount2 = itemCount.replace(",", "");
        return Integer.parseInt(itemCount2);
    }
}
