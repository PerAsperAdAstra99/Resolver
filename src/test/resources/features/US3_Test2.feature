
Feature: List items in Test 2

  Background:
    Given user is on the Home Page

  Scenario: As a user I should be able to see 3 values in listgroup
    Then user sees 3 values in list group

  Scenario: As a user I should be able to see item's value
    Then user sees item number 2 's value as "List Item 2"

  Scenario: As a user I should be able to see item's badge value
    Then user sees item number 2 's badge value as "6"



