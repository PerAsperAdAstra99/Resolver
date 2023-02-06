@wip
Feature: Negative testing of login feature

 # Validation if the warning message is displayed needs to be performed visually therefore in this test case I verify the content of the message

  Background:
    Given user is on the Home Page

  Scenario: As a user I should not be able to log in if the email box empty
    When user types password "1234567890" into password box
    And user clicks login button
    Then warning message for email box should not be blank

  Scenario: As a user i should not be able to log in if the password box is empty
    When user types "tpayley0@phoca.cz" into email box
    And user clicks login button
    Then warning message for password box should not be blank


  Scenario: Verification of the warning message when attempting to log in without email
    When user types password "1234567890" into password box
    And user clicks login button
    Then warning message for email should contain "Please fill out this field."

  Scenario: As a user I should not be able to log in if the email is missing a part before "@"
    When user types "@phoca.cz" into email box
    Then warning message for email should contain "Please enter a part followed by '@'."

  Scenario: As a user I should not be able to log n if the email is missing a part after "@"
    When user types "tpayley0@" into email box
    Then warning message for email should contain "Please enter a part following '@'."

  Scenario: As a user I should not be able to log in if the email has no "@"
    When user types "tpayley0" into email box
    Then warning message for email should contain "Please include an '@' in the email address."



