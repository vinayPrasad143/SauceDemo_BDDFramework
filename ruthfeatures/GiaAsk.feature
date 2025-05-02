@system_test
Feature: GIA ASK page Functionality
  Background:
    Given Open the chrome browser and Navigate to "https://gia-test.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Chandana@2406" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page
@askgia
    Scenario: Validate the functionality of the GIA ASK page
      Given Enter the "What are the differences between respondent types?" in the query search box
      And Click on the search Query button
      Then Verify the display of the Response
      And click on like icon and verify the like icon is highlighted or not
      And click on unlike icon and verify the unlike icon is highlighted or not
      And click on the copy and verify that the copy of the response is copied to the word doc or not
      And click on the citations icon
      And Verify the citations


