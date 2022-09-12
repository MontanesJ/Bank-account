Feature: Account is credited with amount


  Scenario: account withdrawal
    Given a new account with a balance at zero
    When the account make a deposit with 10
    When the account make a deposit with 10
    When the account make a withdrawal with 10
    Then the new balance should be 10