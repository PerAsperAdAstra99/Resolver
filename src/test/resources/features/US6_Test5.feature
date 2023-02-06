
Feature: Test 5 button functionality

  Background:
    Given user is on the Home Page

  Scenario: As a user I should be able to click button, see success message and then not able to access button
    When user waits for the button to be displayed and clicks it
    Then user sees success message displayed
    Then user sees that message content is "You clicked a button!"
    Then user is not able to access button





