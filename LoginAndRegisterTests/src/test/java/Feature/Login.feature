Feature: Login with Valid Credentials

  Scenario: Successful Login with Valid Credentials
    Given User open browser
    And open URL "https://practicetestautomation.com/practice-test-login/"
    When check is Logo is displayed
    And User enter usename and password
    And click Submit button
    Then check Log out button is displayed