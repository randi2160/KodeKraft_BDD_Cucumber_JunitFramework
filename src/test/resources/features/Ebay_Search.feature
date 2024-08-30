Feature: Validate Search Resuls from home page by keyword and combo of keyword and category
  Scenario: Executing search from home page
    Given that i am on eBay Home Page
    When I will search for "iPhone 11"
    Then I will validate at least 100000 search items present