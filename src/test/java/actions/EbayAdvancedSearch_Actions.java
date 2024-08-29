package actions;

import elements.EbayAdvancedSearch_Elements;
import org.openqa.selenium.WebDriver;
import steps.Common_Steps;

public class EbayAdvancedSearch_Actions {

    private WebDriver driver;
    EbayAdvancedSearch_Elements ebayadvancedsearch_elements;

    public EbayAdvancedSearch_Actions(Common_Steps common_steps) {
        this.driver = common_steps.getDriver();
        ebayadvancedsearch_elements = new EbayAdvancedSearch_Elements(driver);
    }

    public void clickOnEbayLogo() {
        ebayadvancedsearch_elements.logo.click();
    }

    public void enterSearchString(String string) {
        ebayadvancedsearch_elements.AdvanceSearchBox.sendKeys(string);
    }

    // Commented out method to enter an exclude string.
    // Uncomment this method if you plan to implement it later.
    /*
    public void enterExcludeString(String string) {
        ebayadvancedsearch_elements.excludeString.sendKeys(string);
    }
    */

    public void enterMinPrice(String string) {
        ebayadvancedsearch_elements.minprice.sendKeys(string);
    }

    public void enterMaxPrice(String string) {
        ebayadvancedsearch_elements.maxprice.sendKeys(string);
    }

    public void clickOnSearchBtn() {
        ebayadvancedsearch_elements.AdvSearchSubmitButton.click();
    }

    public int getSearchResultsCount() {
        String countText = ebayadvancedsearch_elements.searchResultsCount.getText().trim();
        String numericCountText = countText.replaceAll("[^\\d]", "");
        return Integer.parseInt(numericCountText);
    }

    // This was commented out and duplicated, so it is kept as a comment in case it needs to be revisited.
    // public int getSearchResultsCount() {
    //    ebayadvancedsearch_elements.searchResultsCount
    // }
}
