@system_test
Feature: Products page functionality

  Background:
    Given Open the chrome browser and Navigate to "https://www.saucedemo.com/"
    And Enter "standard_user" in the username field
    And Enter "secret_sauce" in the password field
    And click on the Login button

  @smoke @sanity @regression
  Scenario: Verify whether the user can able to Add multiple items to Cart or Not
    When click on the first item "Sauce Labs Backpack"
    And click on the second item "Sauce Labs Back Light"
    Then Verify the increase in count to 2 for the Items Added

  @smoke @sanity @regression
  Scenario: Verify whether the user can able to remove the Items from the cart or not
    When click on the first item "Sauce Labs Backpack"
    And click on the second item "Sauce Labs Fleece Jacket"
    And click on Remove button on the Item "Sauce Labs Fleece Jacket"
    Then Verify the decrease in count to 1 for the Items removed

  @regression @sanity @now
  Scenario: Validate the display of the Dropdown values
    When click on dropdown filter
    And Retrieves option from the "dropdownmenu"
    Then The dropdown should contain the following values:
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |
    Then I select each dropdown value and verify the displayed selection
    Then I validate that products are sorted correctly by filter selection




