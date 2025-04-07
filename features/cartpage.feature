@system_test
Feature: Cart page functionality

  Background:
    Given Open the chrome browser and navigate to the "https://www.saucedemo.com/"
    And enter the "standard_user" in the username text field
    And enter the "secret_sauce" in the password text field
    And click on the login button
    And click one item from the products page
    And Click second item from the products page

  @sanity @regression @smoke
  Scenario: Validate that the cart page displayed with the added items
    When click on the Cart icon/button
    Then verify the add items in the cart

  @smoke @sanity
  Scenario: Validate whether the added items are present or not in the cart
    When click on the Cart icon/button
    Then Verify the added items present in the cart page or not