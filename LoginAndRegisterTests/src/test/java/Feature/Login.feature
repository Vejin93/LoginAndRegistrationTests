Feature: Login with Valid Credentials

  Scenario: Successful Login with Valid Credentials
    Given User open browser
    And open URL
    When check is Logo is displayed
    And User enter username and password
    And click Submit button
    Then check Log out button is displayed

    Scenario: Unsuccessful Login with invalid username
      Given User open browser
      And open URL
      When check is Logo is displayed
      And User enter invalid username and password
      And click Submit button
      Then check is error for invalid username is displayed

  Scenario: Unsuccessful Login with invalid password
    Given User open browser
    And open URL
    When check is Logo is displayed
    And User enter username and invalid password
    And click Submit button
    Then check is error for invalid password is displayed