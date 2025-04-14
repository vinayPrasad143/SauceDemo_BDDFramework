@system_test
Feature: GIA ASK page Functionality
  Background:
    Given Open the chrome browser and Navigate to "https://gia-test.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Vinay@123" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page
@now
    Scenario: Validate the functionality of the GIA ASK page
      Given Enter the "What are the differences between respondent types?" in the query search box
      And Click on the search Query button
      Then Verify the display of the Response
      And click on the citations icon
      And Verify the citations
      And click on like button and verify the like button is highlighted or not
      And click on unlike button and verify the unlike button is highlighted or not

