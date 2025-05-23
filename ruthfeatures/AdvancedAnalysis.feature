@system_test
Feature: AdvancedAnalysis page Functionality

  Background:
    Given Open the chrome browser and Navigate to "https://gia-demo.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Chandana@2406" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page by comparing with the Home page URL

  @advancedanalysis
  Scenario Outline: Validate the functionality of the AdvancedAnalysis page
    Given Navigate to the AdvancedAnalysis page
    And Verify the functionality of the collapse and expand of Trending Topics section
    Then User should see the insight section text "Get detailed insights on trending topics" for default screen when nothing is selected on Topics section
    When select "<country>" from the country dropdown filter
    And select "<category>" from the category dropdown filter
    And select "<time period>" from the Time period dropdown filter
    And select "<respondent type>" from the Respondent Type dropdown filter
    Then user should see the result for all the Topics for the selected filter combination "<country>" and "<category>" and "<time period>" and "<respondent type>" combination
    And click on Helpful icon and verify the Helpful icon is highlighted or not
    And click on NotHelpful icon and verify the NotHelpful icon is highlighted or not
    And click on the copy icon and verify that the copy of the response is copied to the word doc or not
    And user should see filter summary as "Country: <country> ; Category: <category> ; Time period: <time period> ; Respondent type: <respondent type>"
    Examples:

      | country | category        | time period | respondent type |
      | UK      | Ice Cream       | 2024H2      | Women             |

