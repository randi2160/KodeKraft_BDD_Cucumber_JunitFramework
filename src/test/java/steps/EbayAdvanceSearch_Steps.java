package steps;

import actions.Common_Actions;
import actions.EbayAdvancedSearch_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

public class EbayAdvanceSearch_Steps {

    Common_Actions common_actions;
    EbayAdvancedSearch_Actions ebayAdvancedSearchActions;

    public EbayAdvanceSearch_Steps(Common_Actions common_actions, EbayAdvancedSearch_Actions ebayAdvancedSearchAction) {
        this.common_actions = common_actions;
        this.ebayAdvancedSearchActions = ebayAdvancedSearchAction;
    }

    @Given("I am on the eBay Advanced Search Page")
    public void i_am_on_the_e_bay_advanced_search_page() {
        common_actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on the eBay logo")
    public void i_click_on_the_e_bay_logo() {
        ebayAdvancedSearchActions.clickOnEbayLogo();
    }

    @Then("I am navigated back to the eBay home page")
    public void i_am_navigated_back_to_the_e_bay_home_page() {
        String ExpUrl = "https://www.ebay.com/";
        String actUrl = common_actions.getCurrentPageUrl();
        assertEquals(ExpUrl, actUrl);
    }

    @When("I search for an item and added min and maximum price")
    public void iSearchForAnItemAndAddedMinAndMaximumPrice(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String keyword = data.get(0).get("keyword");
        String min = data.get(0).get("min");
        String max = data.get(0).get("max");

        ebayAdvancedSearchActions.enterSearchString(keyword);
        ebayAdvancedSearchActions.enterMinPrice(min);
        ebayAdvancedSearchActions.enterMaxPrice(max);
        ebayAdvancedSearchActions.clickOnSearchBtn();
    }

    @Then("I validate at least {int} search items present")
    public void i_validate_at_least_search_items_present(Integer expectedCount) {
        int itemCount = ebayAdvancedSearchActions.getSearchResultsCount();
        if (itemCount < expectedCount) {
            fail("Item count is less than " + expectedCount);
        }
    }
}
