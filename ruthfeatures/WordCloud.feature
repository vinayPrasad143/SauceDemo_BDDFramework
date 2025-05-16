@system_test
Feature: Word Cloud page Functionality

  Background:
    Given Open the chrome browser and Navigate to "https://gia-demo.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Chandana@2406" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page by comparing with the Home page URL

  @wordcloud
  Scenario Outline: Validate the functionality of the WordCloud page
    Given Navigate to the Word cloud page
    When select "<country>" from the country dropdown
    And select "<category>" from the category dropdown
    And select "<time period>" from the Time period dropdown
    And select "<respondent type>" from the Respondent Type dropdown
    And select "<brand>" from the Brand dropdown
    Then should see the result for the selected filter combination "<country>" and "<category>" and "<time period>" and "<respondent type>" and "<brand>" and verify the sentiment icons are clickable and data loading fine

    Examples:

      | country | category        | time period | respondent type | brand  |
      | Canada  | Facial Cleanser | 2023H2      | Women           | Kiehls |


