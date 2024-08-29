package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class EbaySearch_Steps {

    WebDriver driver;

    public EbaySearch_Steps(Common_Steps commonSteps)
    {
        this.driver=commonSteps.getDriver();
    }

    // Initialize WebDriver before each scenario


    @Given("that i am on eBay Home Page")
    public void that_i_am_on_e_bay_home_page() {
        driver.get("http://www.ebay.com");
    }

    @When("I will search for {string}")
    public void i_will_search_for(String item) {
        driver.findElement(By.id("gh-ac")).sendKeys(item);
        driver.findElement(By.id("gh-btn")).click();
    }

    @Then("I will validate at least {int} search items present")
    public void i_will_validate_at_least_search_items_present(Integer expectedCount) {
        String countText = driver.findElement(By.cssSelector(".srp-controls__count-heading")).getText();
        String numericCountText = countText.replaceAll("[^\\d]", "");
        int itemCount = Integer.parseInt(numericCountText);
        if (itemCount < expectedCount) {
            fail("Item count is less than " + expectedCount);
        }
    }


}
