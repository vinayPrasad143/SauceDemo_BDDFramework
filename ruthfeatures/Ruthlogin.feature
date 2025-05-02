@system_test @ruth
Feature: Login functionality
  #Gherkin language
  Background:
    Given Open the chrome browser and Navigate to "https://gia-test.graphenesvc.com/"

  @smoke @login
  Scenario: Validate the login with the Valid Credentials
    When click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Chandana@2406" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page