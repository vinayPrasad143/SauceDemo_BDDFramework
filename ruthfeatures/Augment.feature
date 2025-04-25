@system_test
Feature: Augment page Functionality

  Background:
    Given Open the chrome browser and Navigate to "https://gia-test.graphenesvc.com/"
    And click on the GrapheneLogo
    And Enter "vinayprasad@graphenesvc.com" in the username field
    And click on the Next button
    And Enter "Vinay@123" in the password field
    And click on the SignIn button
    And Click on stay signedIn no button
    Then Verify the navigation of the ASKGIA page

  @augment
  Scenario Outline: Validate the functionality of the Augment page
    Given Navigate to the Augment page
    When I select "<country>" from the country dropdown
    And I select "<category>" from the category dropdown
    And I select "<time period>" from the Time period dropdown
    Then I should see the result for "<country>" and "<category>" and "<time period>" by selecting each themes for all the Topics of interests

    Examples:

      | country | category  | time period |
      | USA     | Ice Cream | 2024H2      |
      | USA     | Ice Cream | 2024H1      |