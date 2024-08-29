package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearch_Elements {
    WebDriver driver;

    public EbayAdvancedSearch_Elements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = (".srp-controls__count-heading")) public WebElement searchResultsCount;
    //@FindBy(css = ".srp-controls__count-heading") public WebElement searchResultsCount;

    @FindBy(id = "gh-la") public WebElement logo;
    @FindBy(xpath="//input[@id='_nkw']") public WebElement AdvanceSearchBox;
    @FindBy(xpath="//input[@name='_udlo']") public WebElement minprice;
    @FindBy(id="s0-1-17-5[2]-@range-comp[]-@range-textbox[]_1-textbox") public WebElement maxprice;
    @FindBy(xpath="//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']") public WebElement AdvSearchSubmitButton;
}
