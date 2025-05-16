@system_test
Feature: Qual Deep Dive page Functionality

  Background:
    Given Open the chrome browser and Navigate to "https://gia-demo.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Chandana@2406" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page by comparing with the Home page URL

  @qualdeepdive
  Scenario Outline: Validate the functionality of the DeepDive page
    Given Navigate to the DeepDive page
    When select "<country>" from the country filter
    And select "<category>" from the category filter
    And select "<time period>" from the Time period filter
    And select "<respondent type>" from the Respondent Type filter
    And select "<brand>" from the Brand filter
    Then i should see the result for "<country>" and "<category>" and "<time period>" and "<respondent type>" and "<brand>"

    Examples:

      | country | category        | time period | respondent type | brand  |
      | Canada  | Facial Cleanser | 2023H2      | Women           | Kiehls |