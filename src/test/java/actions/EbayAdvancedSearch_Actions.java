package actions;

import elements.EbayAdvancedSearch_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import steps.Base;

public class EbayAdvancedSearch_Actions {
    private WebDriver driver;
    private EbayAdvancedSearch_Elements ebayadvancedsearch_elements;

    public EbayAdvancedSearch_Actions(Base common_steps) {
        this.driver = common_steps.getDriver();
        ebayadvancedsearch_elements = new EbayAdvancedSearch_Elements(driver);
        PageFactory.initElements(driver, ebayadvancedsearch_elements); // Initialize elements with PageFactory
    }

    public void clickOnEbayLogo() {
        ebayadvancedsearch_elements.logo.click();
    }

    public void enterSearchString(String string) {
        ebayadvancedsearch_elements.AdvanceSearchBox.sendKeys(string);
    }

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
}
