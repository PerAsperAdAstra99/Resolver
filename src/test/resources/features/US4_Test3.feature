
Feature: Verify Test 3 dropdown functionality

  Background:
    Given user is on the Home Page

  Scenario: As a user I should be able to see selected option
    Then user sees "Option 1" as default selected option

  Scenario Outline: As a user I should be able to select options from the list
    When user selects "<option>" from the dropdown
    Then user sees "<expectedOption>" as selected option
    Examples:
      | option   | expectedOption |
      | Option 1 | Option 1       |
      | Option 2 | Option 2       |
      | Option 3 | Option 3       |