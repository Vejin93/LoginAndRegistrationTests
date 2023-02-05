Feature: Registration with valid parameters

  Scenario: Successful register with valid parameters
    Given User open browser for registration
    And open URL for registration
    When check is Logo is displayed on home page
    And click on Register href on header
    And check if Registration page
    And User enter data for registration
    And click Register button
    Then check text for successful registration