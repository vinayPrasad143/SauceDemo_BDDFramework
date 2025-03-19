@system_test
Feature: Cart page functionality

  Background:
    Given Open the chrome browser and navigate to the "URL"
    And enter the "Username" in the username text field
    And enter the "Password" in the password text field
    And click on the login button
    And Add Items to the cart

  @sanity @regression @smoke
  Scenario: Validate that the cart page displayed with the added items
    When click on the Cart icon/button
    Then verify the add items in the cart

  @smoke @sanity
  Scenario: Validate whether the added items are present or not in the cart
    When click on the Cart icon/button
    Then Verify the added items present in the cart page or not