@system_test
Feature: Compare page Functionality

  Background:
    Given Open the chrome browser and Navigate to "https://gia-test.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Vinay@123" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page

  @compare
  Scenario Outline: Validate the functionality of the Compare page
    Given Navigate to the Compare page
    When select "<category>" from the first category dropdown
    And select "<country1>" from the first country dropdown
    And select "<time period1>" from the first Time period dropdown
    And select "<respondent type1>" from the first Respondent Type dropdown
    And select "<brand1>" from the first Brand dropdown
    And select "<country2>" from the second country dropdown
    And select "<time period2>" from the second Time period dropdown
    And select "<respondent type2>" from the second Respondent Type dropdown
    And select "<brand2>" from the second Brand dropdown
    Then should see the result for "<category>" and "<country1>" and "<time period1>" and "<respondent type1>" and "<brand1>" and "<country2>" and "<time period2>" and "<respondent type2>" and "<brand2>"
    Examples:

      | category        | country1 | time period1 | respondent type1 | brand1 | country2 | time period2 | respondent type2 | brand2 |
      | Facial Cleanser | All      | 2024H2       | All              | All    | USA      | 2024H2       | All              | All    |
      | Ice Cream       | All      | 2024H2       | All              | All    | USA      | 2024H2       | All              | All    |