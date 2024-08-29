package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbayHome_Elements {
  WebDriver driver;

    public EbayHome_Elements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Advanced") public WebElement advancedLink;
@FindBy(id = "gh-ac") public WebElement searchbox;
@FindBy(id="gh-btn") public WebElement SearchButton;
//"gh-cat"
@FindBy(id="gh-cat") public WebElement SearchCategory;
@FindBy(css = (".srp-controls__count-heading")) public WebElement searchResultsCount;
    @FindBy(xpath = "//input[@id='gh-btn']") public WebElement searchButton;
    @FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child") public WebElement numOfItems;
    @FindBy(xpath = "//select[@id='gh-cat']/option']") public List<WebElement> catOptions;

}
