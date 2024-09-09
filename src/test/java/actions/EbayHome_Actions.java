package actions;

import elements.EbayHome_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.Base;
import org.openqa.selenium.By;

import java.util.List;

public class EbayHome_Actions {
    private WebDriver driver;
    private EbayHome_Elements ebayHomeElements;

    public EbayHome_Actions(Base common_steps) {
        this.driver = common_steps.getDriver();
        ebayHomeElements = new EbayHome_Elements(driver);
        PageFactory.initElements(driver, ebayHomeElements); // Initialize elements with PageFactory
    }

    public void clickAdvancedLink() {
        ebayHomeElements.advancedLink.click();
    }

    public void searchAnItem(String searchString) {
        ebayHomeElements.searchbox.sendKeys(searchString);
    }

    public void clickSearchButton() {
        ebayHomeElements.SearchButton.click(); // Access the field directly
    }

    public int getSearchItemsCount() {
        String itemCount = ebayHomeElements.searchResultsCount.getText().trim();
        String itemCount2 = itemCount.replace(",", "");
        return Integer.parseInt(itemCount2);
    }

    public void selectCategoryOption(String option) {
        WebElement categoryDropdown = ebayHomeElements.SearchCategory;
        categoryDropdown.click(); // Open the dropdown

        List<WebElement> categoryOptions = ebayHomeElements.catOptions;
        for (WebElement optionElement : categoryOptions) {
            if (optionElement.getText().trim().equalsIgnoreCase(option)) {
                optionElement.click();
                break;
            }
        }
    }

    public void clickOnLinkByText(String text) {
        driver.findElement(By.linkText(text)).click();
    }
}
