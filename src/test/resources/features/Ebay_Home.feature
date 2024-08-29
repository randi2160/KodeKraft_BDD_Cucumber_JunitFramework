Feature: eBay Home Page Scenarios

  Scenario: eBay Home page and click advanced search link
    Given I am on eBay Home Page
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  Scenario: Search items count
    Given I am on eBay Home Page
    When I search for "iPhone 11"
    Then I validate at least 1000 search items present

  Scenario: Search items count2
    Given I am on eBay Home Page
    When I search for "Toy Cars"
    Then I validate at least 100 search items present




  Scenario Outline: Click on link and Verify the title and link url
    Given I am on eBay Home Page
    When I click on '<link>'
    Then I validate that the page navigates to: '<url>' and title contains '<title>'
    Examples:
      | link    | url                                                                | title       |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334     | eBay Motors |
      | Fashion | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Clothing, Shoes & Accessories     |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497                 | Toys        |






