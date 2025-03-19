@system_test
Feature: Login functionality
  #Gherkin language
  Background:
    Given Open the chrome browser and Navigate to "https://www.saucedemo.com/"

  @smoke @sanity @Regression
  Scenario: Validate the login with the Valid Credentials
    When Enter "standard_user" in the username field
    And Enter "secret_sauce" in the password field
    And click on the Login button
    Then Verify the navigation of the home page

  @Regression @sanity
  Scenario Outline: Login failure Scenario
    When Enter "<username>" in the username field
    And Enter "<password>" in the password field
    And click on the Login button
    Then Verify the display of the validation message "<errormsg>"

    @UAT @QA
    Examples:

      | username      | password | errormsg                                                                  |
      | vinay         | prasad   | Epic sadface: Username and password do not match any user in this service |
      | standard_user |          | Epic sadface: Password is required                                        |
    @QA
    Examples:
      | username | password     | errormsg                           |
      |          | secret_sauce | Epic sadface: Username is required |
      |          |              | Epic sadface: Username is required |




