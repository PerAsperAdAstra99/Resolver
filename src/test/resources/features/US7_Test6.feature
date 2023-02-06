
Feature: Verification if table's values in Test 6

  Background:
    Given user is on the Home Page

    Scenario: As a user I should be able to find value of cell in the table by given coordinates(staring at 0 in the top left corner)
      Then user sees value of the table cell with coordinates 2, 2 as "Ventosanzap"