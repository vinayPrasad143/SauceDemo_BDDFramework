@system_test
Feature: Products page functionality

  Background:
    Given Open the chrome browser and Navigate to "https://www.saucedemo.com/"
    And Enter "standard_user" in the username field
    And Enter "secret_sauce" in the password field
    And click on the Login button

  @smoke @sanity @regression
  Scenario: Verify whether the user can able to Add multiple items to Cart or Not
    When click on the item "<Sauce Labs Backpack>"
    And click on the second item "<Sauce Labs Back Light>"
    Then Verify the added Items
    And Verify the increase in count to 2 for the Items Added

  @smoke @sanity @regression
  Scenario: Verify whether the user can able to remove the Items from the cart or not
    When click on the item "<Sauce Labs Backpack>"
    And click on the item "<Sauce Labs Back Light>"
    And click on Remove button on the Item "<Sauce Labs Backpack>"
    And click on Remove button on the Item "<Sauce Labs Back Light>"
    Then Verify that the Items added to the cart are removed
    And Verify the decrease in count to 0 for the Items removed

  @regression @sanity
  Scenario Outline: Validate the display of the Dropdown values
    When click on dropdown filter
    Then Verify the display of the "<filter values>"

    Examples:
      | filter values      |
      | Name(A to Z)        |
      | Name(Z to A)       |
      | Price(Low to High) |
      | Price(High to Low) |


