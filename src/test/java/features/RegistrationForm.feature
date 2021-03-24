Feature: Registration Form.

  Scenario: User can register with valid details.
    Given User is on registration page
    When User input all valid details
    Then User should get valid submition message

