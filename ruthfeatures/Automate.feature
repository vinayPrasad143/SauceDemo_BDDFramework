@system_test
Feature: Automate Tab Functionality
  Background:
    Given Open the chrome browser and Navigate to "https://gia-test.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Chandana@2406" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page
  @automate
  Scenario: Validate the navigation to Mr site and URL
    Given I open the application and click on the Automate tab
    When I switch to the new tab
    Then I should be on "https://transcripts-test.ezythemes.com/qbqc/1255" and Validate the Navigation
    And I close the new tab and switch back to the original tab