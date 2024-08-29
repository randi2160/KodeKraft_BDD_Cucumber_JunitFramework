Feature: Ebay Advanced Search Page

  Scenario: eBay logo on Advanced Search Page
    Given I am on the eBay Advanced Search Page
    When I click on the eBay logo
    Then I am navigated back to the eBay home page

 @p234
  Scenario: I want to perform a search on Advance search page
    Given I am on the eBay Advanced Search Page
    When I search for an item and added min and maximum price
      | keyword  | min | max |
      | iphone13 | 50  | 150 |
      #| iphone14 | 50  | 250 |
      #| iphone11 | 50  | 550 |


