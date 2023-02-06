
Feature: Verify that login function is accessible

  Background:
    Given user is on the Home Page


  Scenario: As a user I should be able to see email, password input boxes and login button

    Then user should be able to see email, password input boxes and login button


  Scenario: As a user I should be able to click login button
    Then user should be able to click login button

  Scenario Outline: As a user I should be able to input email and password
    When user types "<email>"  into email box
    And user types "<password>" into password box
    Then "<email>" and "<password>" should be present in respective fields

    Examples:
      | email                     | password   |
      | aswyndley2@yellowbook.com | 1234567890 |
      | njanaszewski1@wisc.edu    | 007007     |
      | aswyndley2@yellowbook.com | abcdefg    |

