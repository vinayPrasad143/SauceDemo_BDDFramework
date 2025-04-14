Feature: AdvancedAnalysis page Functionality

  Background:
    Given Open the chrome browser and Navigate to "https://gia-test.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Vinay@123" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page

  @advancedanalysis
  Scenario Outline: Validate the functionality of the AdvancedAnalysis page
    Given Navigate to the AdvancedAnalysis page
    And Verify the functionality of the collapse and expand of Trending Topics section
    Then User should see the insight section text "Get detailed insights on trending topics" for default screen when nothing is selected on Topics section
    When select "<country>" from the country dropdown filter
    And select "<category>" from the category dropdown filter
    And select "<time period>" from the Time period dropdown filter
    And select "<respondent type>" from the Respondent Type dropdown filter
    Then user should see the result for for all the Topics for "<country>" and "<category>" and "<time period>" and "<respondent type>" combination
    Then I click all feedback buttons and save the third feedback to a Word file
    Then user should see filter summary as "Country: <country> ; Category: <category> ; Time period: <time period> ; Respondent type: <respondent type>"
    Examples:

      | country | category        | time period | respondent type |
      | Canada  | Facial Cleanser | 2023H2      | Women           |
      | USA     | Facial Cleanser | 2024H2      | Men             |
