package steps;

import actions.Common_Actions;
import actions.EbayHome_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.fail;

public class EbayHome_Steps {
    Common_Actions common_actions;
    EbayHome_Actions ebayHome_actions;

    public EbayHome_Steps(Common_Actions common_actions, EbayHome_Actions ebayHome_actions) {
        this.common_actions = common_actions;
        this.ebayHome_actions = ebayHome_actions;
    }

    @Given("I am on eBay Home Page")
    public void i_am_on_ebay_home_page() {
        common_actions.goToUrl("https://ebay.com");
    }

    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
        ebayHome_actions.clickAdvancedLink();
    }

    @Then("I navigate to Advanced Search page")
    public void i_navigate_to_advanced_search_page() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actUrl = common_actions.getCurrentPageUrl();
        if (!expectedUrl.equals(actUrl)) {
            fail("Did not navigate to the expected advanced search page.");
        }
    }

    @When("I search for {string}")
    public void i_search_for(String item) {
        ebayHome_actions.searchAnItem(item);
        ebayHome_actions.clickSearchButton();
    }

    @When("I search for {string} in {string} category")
    public void i_search_for_in_category(String item, String category) {
        ebayHome_actions.searchAnItem(item);
        ebayHome_actions.selectCategoryOption(category);
        ebayHome_actions.clickSearchButton();
    }

    @Then("I validate at least {int} search items present in advanced search")
    public void i_validate_at_least_search_items_present_in_advanced_search(Integer expectedCount) {
        int itemCount = ebayHome_actions.getSearchItemsCount();
        if (itemCount < expectedCount) {
            fail("Item count is less than " + expectedCount);
        }
    }

    @When("I click on {string}")
    public void i_click_on(String linkText) {
        ebayHome_actions.clickOnLinkByText(linkText);
    }
/*
    @Then("I validate that the page navigates to {string} and title contains {string}")
    public void i_validate_at_that_page_navigates_to_and_title_contains(String url, String title) {
        String actUrl = common_actions.getCurrentPageUrl();
        String actTitle = common_actions.getCurrentPageTitle();
        if (!actUrl.equals(url)) {
            fail("Page did not navigate to the expected URL: " + url);
        }
        if (!actTitle.contains(title)) {
            fail("Title mismatch: expected title to contain '" + title + "' but was '" + actTitle + "'");
        }
    }
}

*/

    @Then("I validate that the page navigates to {string} and title contains {string}")
    public void i_validate_that_the_page_navigates_to_and_title_contains(String url, String title) {
        String actUrl = common_actions.getCurrentPageUrl();
        String actTitle = common_actions.getCurrentPageTitle();

        if (!actUrl.equals(url)) {
            fail("Page did not navigate to the expected URL: " + url);
        }
        if (!actTitle.contains(title)) {
            fail("Title mismatch: expected title to contain '" + title + "' but was '" + actTitle + "'");
        }
    }

    @Then("I validate that the page navigates to: {string} and title contains {string}")
    public void iValidateThatThePageNavigatesToAndTitleContains(String url, String title) {
        String actUrl = common_actions.getCurrentPageUrl();
        String actTitle = common_actions.getCurrentPageTitle();

        if (!actUrl.equals(url)) {
            fail("Page did not navigate to the expected URL: " + url);
        }
        if (!actTitle.contains(title)) {
            fail("Title mismatch: expected title to contain '" + title + "' but was '" + actTitle + "'");
        }
    }
}